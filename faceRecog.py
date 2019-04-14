'''
Tutorial for basic facial recog code found at:
https://realpython.com/face-recognition-with-python/

make sure you have cv2 installed
    >>pip install opencv-python
    >>pip install opencv-contrib-python

to run:
(if command line arguments are enabled)
>> python faceRecog.py abba.png haarcascade_frontalface_default.xml

(otherwise)
>>python faceRecog.py
'''

import cv2
import sys

# Get supplied values
imagePath = sys.argv[1]


# Create the haar cascade
faceCascade = cv2.CascadeClassifier(cv2.data.haarcascades + "haarcascade_frontalface_default.xml")
eye_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_eye.xml')


image = cv2.imread(imagePath)
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Detect faces in the image
faces = faceCascade.detectMultiScale(
    gray,
    scaleFactor=1.1,
    minNeighbors=5,
    minSize=(30, 30)
)

facePoints = [] #toReturn

# print ( "Found {0} faces!".format(len(faces)) )


# Draw a rectangle around the faces
for x, y, w, h in faces:
    cv2.rectangle(image, (x, y), (x+w, y+h), (0, 255, 0), 2)
    roi_gray = gray[y:y+h, x:x+w]
    roi_color = image[y:y+h, x:x+w]
    eyes = eye_cascade.detectMultiScale(roi_gray)
    toAppend = [x, y, w, h]


    j = 0
    toAppendtotoAppend = []
    for (ex,ey,ew,eh) in eyes:
        toAppendtotoAppend.append(x + ex)
        toAppendtotoAppend.append(y + ey)
        toAppendtotoAppend.append(ew)
        toAppendtotoAppend.append(eh)


        cv2.rectangle(roi_color,(ex,ey),(ex+ew,ey+eh),(0,255,0),2)
        j+=1
        if j == 2:
            toAppend.append(toAppendtotoAppend)
            break

    facePoints.append(toAppend)


# cv2.imshow("Faces found", image)
# cv2.waitKey(0)

#now to write to a file which will be read by our Java app:

data = open("./picData.txt", "w")

for face in facePoints:
    if len(face) == 4:
        for point in face:
            data.write(str(point) + " ")
    elif len(face) == 5:
        for i in range(0, 4):
            data.write(str(face[i]) + " ")
        data.write("\n")
        for eyePoint in face[4]:
            data.write(str(eyePoint) + " ")

    data.write("\n")

data.close()
