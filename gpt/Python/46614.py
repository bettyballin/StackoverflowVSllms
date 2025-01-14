from PIL import Image, ImageOps\n\ndef add_border(input_image_path, output_image_path, border_size):\n    img = Image.open(input_image_path)\n    \n    # Create a new image with white background\n    bordered_img = ImageOps.expand(img, border=border_size, fill='white')\n    \n    # Save the image with the border\n    bordered_img.save(output_image_path)\n\ndef create_thumbnail(input_image_path, output_image_path, thumbnail_size, border_size):\n    img = Image.open(input_image_path)\n    \n    # Create the thumbnail\n    img.thumbnail(thumbnail_size)\n    \n    # Add a white border\n    bordered_img = ImageOps.expand(img, border=border_size, fill='white')\n    \n    # Save the thumbnail with the border\n    bordered_img.save(output_image_path)\n\n# Example usage\ninput_image_path = 'path/to/your/image.jpg'\noutput_image_path = 'path/to/your/thumbnail_with_border.jpg'\nthumbnail_size = (150, 150)  # Desired thumbnail size\nborder_size = 10  # Border size in pixels\n\ncreate_thumbnail(input_image_path, output_image_path, thumbnail_size, border_size)