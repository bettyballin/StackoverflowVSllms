require 'prawn'\n\nPrawn::Document.generate("flowing_text_around_image.pdf") do\n  # Define the width and height of your document\n  page_width = bounds.width\n  page_height = bounds.height\n\n  # Path to your image file\n  image_path = "path/to/your/image.png"\n\n  # Dimensions of the image\n  image_instance = MiniMagick::Image.open(image_path)\n  image_width = image_instance.width * 0.2 # scale down the image width\n  image_height = image_instance.height * 0.2\n\n  # Position where you want to place your image (right upper corner)\n  x_position = page_width - image_width\n  y_position = page_height - image_height\n\n  # Draw the image at the specified position\n  bounding_box [x_position, y_position], width: image_width, height: image_height do\n    image image_path, fit: [image_width, image_height]\n  end\n\n  # Move the cursor to start writing text left of the image\n  move_down(40) # move down a bit from top margin\n  bounding_box [bounds.left, y_position - 10], width: x_position - 20 do\n    # Write your main content here\n    text "This is some introductory text that starts to the left of the image. We need to make it long enough to flow under and around the image as we continue writing.", inline_format: true\n  end\n\n  bounding_box [bounds.left, y_position - image_height - 20], width: page_width do\n    # Continue writing after the image ends\n    text "This is additional content that starts below the image and uses the full width of the page."\n  end\nend