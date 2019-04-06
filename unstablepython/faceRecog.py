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

# Get supplied values
# imagePath = sys.argv[1]
# cascPath = sys.argv[2]

imagePath = 'abba.png'
cascPath = 'haarcascade_frontalface_default.xml'
# cascPath = cv2.data.haarcascades

# Create the haar cascade
faceCascade = cv2.CascadeClassifier(cascPath)

# Read the image
image = cv2.imread(imagePath)
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Detect faces in the image
faces = faceCascade.detectMultiScale(
    gray,
    scaleFactor=1.1,
    minNeighbors=5,
    minSize=(30, 30)
    #flags = cv2.CV_HAAR_SCALE_IMAGE
)

print ( "Found {0} faces!".format(len(faces)) )

# Draw a rectangle around the faces
for (x, y, w, h) in faces:
    cv2.rectangle(image, (x, y), (x+w, y+h), (0, 255, 0), 2)

cv2.imshow("Faces found", image)
cv2.waitKey(0)
