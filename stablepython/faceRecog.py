'''
Tutorial for this code found at:
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

image = cv2.imread(imagePath)
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Detect faces in the image
faces = faceCascade.detectMultiScale(
    gray,
    scaleFactor=1.1,
    minNeighbors=5,
    minSize=(30, 30)
)

print ( "Found {0} faces!".format(len(faces)) )

print (faces[0][0])

# Draw a rectangle around the faces
for x, y, w, h in faces:
    cv2.rectangle(image, (x, y), (x+w, y+h), (0, 255, 0), 2)

cv2.imshow("Faces found", image)
cv2.waitKey(0)
