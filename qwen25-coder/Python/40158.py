from django.http import HttpResponse\nfrom PIL import Image, ImageDraw  # Make sure you have pillow installed: pip install Pillow\nfrom io import BytesIO\nfrom random import randint\n\ndef chart(request):\n    # Create a new image with white background\n    img = Image.new("RGB", (300, 300), "#FFFFFF")\n    \n    # Generate some data points\n    data = [(i, randint(100, 200)) for i in range(0, 300, 10)]\n    draw = ImageDraw.Draw(img)\n    \n    # Draw a polygon using the generated data points and black color\n    draw.polygon(data, fill="#000000")\n    \n    # Use BytesIO to create an in-memory file-like object\n    output = BytesIO()\n    img.save(output, format='PNG')  # Save the image to the in-memory file in PNG format\n    \n    # Set the cursor to the beginning of the stream to serve the image correctly\n    output.seek(0)\n    \n    # Return the image as an HttpResponse with the appropriate content type\n    return HttpResponse(output, content_type="image/png")