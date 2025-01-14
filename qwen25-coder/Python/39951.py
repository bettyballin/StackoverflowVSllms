import cv2\n\ndef find_image(large_image_path, small_image_path):\n    # Load images\n    large_image = cv2.imread(large_image_path)\n    small_image = cv2.imread(small_image_path)\n\n    # Perform template matching\n    result = cv2.matchTemplate(large_image, small_image, cv2.TM_CCOEFF_NORMED)\n\n    # Get the best match location\n    min_val, max_val, min_loc, max_loc = cv2.minMaxLoc(result)\n\n    # If you are using correlation coefficient method, you want the location with maximum value.\n    top_left = max_loc\n\n    return top_left\n\n# Example usage\nlarge_image_path = 'path_to_large_image.jpg'\nsmall_image_path = 'path_to_small_image.jpg'\n\nx, y = find_image(large_image_path, small_image_path)\nprint(f"Target image found at: ({x}, {y})")