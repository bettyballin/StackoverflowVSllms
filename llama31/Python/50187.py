from PIL import Image\n\ndef scale_to_fill_bounding_box(image, bounding_box):\n    """\n    Scale an image to completely fill a bounding box, \n    potentially cropping the image in the process.\n    \n    :param image: The input image\n    :param bounding_box: A tuple (width, height) representing the bounding box\n    :return: The scaled and potentially cropped image\n    """\n    img_width, img_height = image.size\n    box_width, box_height = bounding_box\n    \n    # Calculate the scaling factor\n    scale_factor = min(box_width / img_width, box_height / img_height)\n    \n    # Scale the image\n    new_width = int(img_width * scale_factor)\n    new_height = int(img_height * scale_factor)\n    image = image.resize((new_width, new_height))\n    \n    # Calculate the cropping coordinates\n    left = (box_width - new_width) // 2\n    top = (box_height - new_height) // 2\n    \n    # Create a new image with the bounding box dimensions\n    new_image = Image.new('RGB', bounding_box)\n    \n    # Paste the scaled image into the new image, potentially cropping it\n    new_image.paste(image, (left, top))\n    \n    return new_image