<?php\n// Load the image\n$imagePath = 'path/to/your/image.jpg';\n$image = imagecreatefromjpeg($imagePath);\n\n// Check if the image was loaded successfully\nif (!$image) {\n    die('Failed to load image.');\n}\n\n// Convert the image to greyscale\nif (!imagefilter($image, IMG_FILTER_GRAYSCALE)) {\n    die('Failed to apply greyscale filter.');\n}\n\n// Save the greyscale image\n$greyscaleImagePath = 'path/to/save/greyscale_image.jpg';\nif (!imagejpeg($image, $greyscaleImagePath)) {\n    die('Failed to save greyscale image.');\n}\n\n// Free up memory\nimagedestroy($image);\n\necho 'Image successfully converted to greyscale.';\n?>