import cv2\n\n# Load the image\nimage_path = 'path_to_your_image_file.png'\nimage = cv2.imread(image_path, 0)  # Load in grayscale\n\n# Perform edge detection\nedges = cv2.Canny(image, 50, 150)\n\n# Find contours\ncontours, _ = cv2.findContours(edges, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)\n\n# Assuming the largest contour is the form boundary\nform_contour = max(contours, key=cv2.contourArea)\nx, y, w, h = cv2.boundingRect(form_contour)\nprint(f"Form bounding box: X={x}, Y={y}, Width={w}, Height={h}")\n\n# Visualize the form boundary\nform_image = cv2.rectangle(image.copy(), (x, y), (x + w, y + h), (255, 0, 0), 2)\ncv2.imshow('Form Boundary', form_image)\ncv2.waitKey(0)\ncv2.destroyAllWindows()