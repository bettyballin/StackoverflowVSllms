import numpy as np\n\ndef create_gradient_mask(width, height, radius):\n    mask = np.zeros((height, width))\n    for y in range(height):\n        for x in range(width):\n            # Distance from center (assuming top-left corner)\n            dx = x - radius\n            dy = y - radius\n            distance = np.sqrt(dx**2 + dy**2)\n            if distance <= radius:\n                mask[y, x] = 1 - (distance / radius)  # Normalize so edge is 0 and center is 1\n    return mask\n\ndef apply_gradient_to_image(image, border_width):\n    height, width, _ = image.shape\n    alpha_channel = np.ones((height, width))\n    \n    for i in range(4):  # For each corner\n        x_offset = 0 if i % 2 == 0 else width - border_width\n        y_offset = 0 if i < 2 else height - border_width\n        corner_mask = create_gradient_mask(border_width, border_width, border_width)\n        \n        alpha_channel[y_offset:y_offset+border_width, x_offset:x_offset+border_width] *= corner_mask\n    \n    # Apply vertical and horizontal gradients here (omitted for brevity)\n    \n    image_with_alpha = np.dstack((image[..., :3], (alpha_channel * 255).astype(np.uint8)))\n    return image_with_alpha\n\n# Example usage\nimport cv2\nimage = np.ones((100, 100, 4)) * 255  # Create a 100x100 white image with alpha channel\nborder_width = 20\nblended_image = apply_gradient_to_image(image, border_width)\ncv2.imwrite('gradient_border.png', blended_image)  # Save the image for visualizatio