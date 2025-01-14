import cv2\n\n   def fitness_function_sift(target_image, generated_image):\n       sift = cv2.SIFT_create()\n       kp1, des1 = sift.detectAndCompute(target_image, None)\n       kp2, des2 = sift.detectAndCompute(generated_image, None)\n       \n       bf = cv2.BFMatcher(cv2.NORM_L2, crossCheck=True)\n       matches = bf.match(des1, des2)\n       \n       return -len(matches)  # Negative because higher matches mean closer similarity