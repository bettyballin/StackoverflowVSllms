from PIL import Image\n\ndef resize_image(input_path, output_path, size):\n    image = Image.open(input_path)\n    resized_image = image.resize(size)\n    resized_image.save(output_path)\n\n# Usage\nresize_image('input.jpg', 'output.jpg', (800, 600))