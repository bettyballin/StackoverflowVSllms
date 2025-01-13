import cv2\n\n# Load image\nimg = cv2.imread('image.jpg')\n\n# Convert to grayscale\ngray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)\n\n# Detect SIFT keypoints and descriptors\nsift = cv2.SIFT_create()\nkp, des = sift.detectAndCompute(gray, None)\n\n# Print the number of keypoints and descriptors\nprint('Keypoints:', len(kp))\nprint('Descriptors:', des.shape)