from PIL import Image\n\ndef resize_image(image_path, width, height):\n    img = Image.open(image_path)\n    img.thumbnail((width, height))\n    img.save(image_path)