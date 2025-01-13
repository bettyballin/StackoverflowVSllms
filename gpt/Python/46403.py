import cv2\nimport numpy as np\n\n# Load the pre-trained Haar Cascades for face and eye detection\nface_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')\neye_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_eye.xml')\n\ndef reduce_red_eye(image_path):\n    # Read the image\n    img = cv2.imread(image_path)\n    img_out = img.copy()\n    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)\n\n    # Detect faces in the image\n    faces = face_cascade.detectMultiScale(gray, 1.3, 5)\n\n    for (x, y, w, h) in faces:\n        roi_face = img[y:y+h, x:x+w]\n        roi_gray = gray[y:y+h, x:x+w]\n\n        # Detect eyes within the face region\n        eyes = eye_cascade.detectMultiScale(roi_gray)\n        for (ex, ey, ew, eh) in eyes:\n            eye = roi_face[ey:ey+eh, ex:ex+ew]\n\n            # Convert the eye region to HSV color space\n            eye_hsv = cv2.cvtColor(eye, cv2.COLOR_BGR2HSV)\n\n            # Define the red color range in HSV\n            lower_red = np.array([0, 50, 50])\n            upper_red = np.array([10, 255, 255])\n\n            # Create a mask for red color\n            mask = cv2.inRange(eye_hsv, lower_red, upper_red)\n\n            # Reduce red channel intensity in the red regions\n            eye[mask > 0] = [0, 0, 0]\n\n            # Replace the eye region with the corrected eye\n            roi_face[ey:ey+eh, ex:ex+ew] = eye\n\n        # Replace the face region with the corrected face\n        img_out[y:y+h, x:x+w] = roi_face\n\n    return img_out\n\n# Example usage\nimage_path = 'path_to_your_image.jpg'\nresult_img = reduce_red_eye(image_path)\n\n# Save or display the result\ncv2.imwrite('red_eye_corrected.jpg', result_img)\n# cv2.imshow('Red Eye Reduction', result_img)\n# cv2.waitKey(0)\n# cv2.destroyAllWindows()