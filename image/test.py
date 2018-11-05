
import cv2
import numpy as np
import  imutils
from scipy.spatial import distance as dist
import pytesseract
# from pyimagesearch.transform import four_point_transform

def order_points(pts):
	xSorted = pts[np.argsort(pts[:, 0]), :]
	leftMost = xSorted[:2, :]
	rightMost = xSorted[2:, :]
	leftMost = leftMost[np.argsort(leftMost[:, 1]), :]
	(tl, bl) = leftMost
	D = dist.cdist(tl[np.newaxis], rightMost, "euclidean")[0]
	(br, tr) = rightMost[np.argsort(D)[::-1], :]
	return np.array([tl, tr, br, bl], dtype="float32")

def order_points_old(pts):
	rect = np.zeros((4, 2), dtype="float32")
	s = pts.sum(axis=1)
	rect[0] = pts[np.argmin(s)]
	rect[2] = pts[np.argmax(s)]
	diff = np.diff(pts, axis=1)
	rect[1] = pts[np.argmin(diff)]
	rect[3] = pts[np.argmax(diff)]
	return rect

def four_point_transform(image, pts):
	rect = order_points(pts)
	(tl, tr, br, bl) = rect
	widthA = np.sqrt(((br[0] - bl[0]) ** 2) + ((br[1] - bl[1]) ** 2))
	widthB = np.sqrt(((tr[0] - tl[0]) ** 2) + ((tr[1] - tl[1]) ** 2))
	maxWidth = max(int(widthA), int(widthB))
	heightA = np.sqrt(((tr[0] - br[0]) ** 2) + ((tr[1] - br[1]) ** 2))
	heightB = np.sqrt(((tl[0] - bl[0]) ** 2) + ((tl[1] - bl[1]) ** 2))
	maxHeight = max(int(heightA), int(heightB))
	dst = np.array([
		[0, 0],
		[maxWidth - 1, 0],
		[maxWidth - 1, maxHeight - 1],
		[0, maxHeight - 1]], dtype = "float32")
	M = cv2.getPerspectiveTransform(rect, dst)
	warped = cv2.warpPerspective(image, M, (maxWidth, maxHeight))
	return warped


def RepresentsInt(s):
    try:
        int(s)
        return True
    except ValueError:
        return False

cap = cv2.VideoCapture(1)
codeis = []
while(True):

    imageSource = '8.jpg'
    ret, image = cap.read()
    height, width, numChannels = image.shape
    image = image[20:height,:]
    imgHSV = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)
    imgHue, imgSaturation, imgValue = cv2.split(imgHSV)
    structuringElement = cv2.getStructuringElement(cv2.MORPH_RECT, (3, 3))
    imgTopHat = cv2.morphologyEx(imgValue, cv2.MORPH_TOPHAT, structuringElement)
    imgBlackHat = cv2.morphologyEx(imgValue, cv2.MORPH_BLACKHAT, structuringElement)
    imgGrayscalePlusTopHat = cv2.add(imgValue, imgTopHat)
    imgGrayscalePlusTopHatMinusBlackHat = cv2.subtract(imgGrayscalePlusTopHat, imgBlackHat)
    #cv2.imshow('gray',imgGrayscalePlusTopHatMinusBlackHat)


    GAUSSIAN_SMOOTH_FILTER_SIZE = (5, 5)
    ADAPTIVE_THRESH_BLOCK_SIZE = 19
    ADAPTIVE_THRESH_WEIGHT = 9
    height, width = imgGrayscalePlusTopHatMinusBlackHat.shape
    imgBlurred = np.zeros((height, width, 1), np.uint8)
    imgBlurred = cv2.GaussianBlur(imgGrayscalePlusTopHatMinusBlackHat, GAUSSIAN_SMOOTH_FILTER_SIZE, 0)
    imgThresh = cv2.adaptiveThreshold(imgBlurred, 255.0, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY_INV, ADAPTIVE_THRESH_BLOCK_SIZE, ADAPTIVE_THRESH_WEIGHT)
    #cv2.imshow('imgThresh',imgThresh)

    kernel = np.ones((3,3), np.uint8)
    morphology = cv2.morphologyEx(imgThresh, cv2.MORPH_OPEN, kernel)
    morphology = cv2.morphologyEx(morphology, cv2.MORPH_OPEN, kernel)
    kernel = np.ones((50,50), np.uint8)
    morphology = cv2.morphologyEx(morphology, cv2.MORPH_CLOSE, kernel)
    #cv2.imshow('morphology',morphology)
    #cv2.imshow('imgThresh',imgThresh)
    # morphology = cv2.morphologyEx(imgThresh, cv2.MORPH_CLOSE, kernel)


    _,contours,_ = cv2.findContours(morphology,cv2.RETR_LIST,cv2.CHAIN_APPROX_SIMPLE)
	# print(contours)
	# print('mos')
	# print(contours)
	# for cnt in contours:
	# 	if cv2.contourArea(cnt) < 100:
	# 		cv2.drawContours(image, [cnt], 0, (0,255,0), 3)
    # box = []
    codeis =[]
    for (i, c) in enumerate(contours):
    	if cv2.contourArea(c) < 100:
    		continue
		cv2.drawContours(image, [c], 0, (0,255,0), 3)
		# print(c)
    	box = cv2.minAreaRect(c)
    	box = cv2.cv.BoxPoints(box) if imutils.is_cv2() else cv2.boxPoints(box)
    	box = np.array(box, dtype="int")
        if len(box)==4:
            pts = np.array(box, dtype = "float32")
            # print(pts)
            warped = four_point_transform(image, box)
            warped = imutils.resize(warped, height=400)
            # print(len(warped[0]))
            if len(warped[0])>=600:
                cv2.drawContours(image, [box], 0, (0,255,0), 3)
                std_code_text = pytesseract.image_to_string(warped[215:250,100:300], lang='tha', config="-l tha --oem 1 --psm 6")
                std_name_text = pytesseract.image_to_string(warped[170:220,100:360], lang='tha', config="-l tha --oem 1 --psm 6")
                warped_im = warped[210:380,30:190].copy()
                codeis.append(warped_im)
                cv2.rectangle(warped,(10,190),(220,400),(0,255,0),3)
                cv2.rectangle(warped,(300,320),(500,370),(0,255,0),3)
                cv2.rectangle(warped,(300,230),(500,250),(0,255,0),3)
                print(std_code_text)
                print(std_name_text)
                if len(std_code_text)==8:
                    cv2.imshow('warped',warped)
                    # cv2.putText(image,'test',(10,10),cv2.FONT_HERSHEY_SIMPLEX, 4,(255,255,255),2,cv2.LINE_AA)
                    if RepresentsInt(std_code_text):
                         codeis.append(int(std_code_text))
                         codeis.append(std_name_text)


                         # print(int(std_code_text))
                # else:
                #     print('not')
    # if len(pts)==4:
    #     warped = four_point_transform(image, box)
    #     warped = imutils.resize(warped, height=400)
    #     cv2.imshow('warped',warped)
    #     tx = pytesseract.image_to_string(warped[215:250,100:300], lang='tha', config="-l tha --oem 1 --psm 6")
    #     print(tx)
	# print('mos wongsakorn')
    if len(codeis)==3:
        print(codeis[1])
        print(codeis[2])
        cv2.imshow('image profile',codeis[0])
    else:
        print('Card not found')
        # cv2.putText(image,'Not',(300,200),cv2.FONT_HERSHEY_SIMPLEX, 4,(255,255,255),2,cv2.LINE_AA)
    cv2.imshow('image',image)
    # cv2.imshow('thresh',thresh)
    # cv2.imshow('morphology',morphology)

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()

cv2.destroyAllWindows()