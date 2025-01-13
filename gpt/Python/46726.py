import pytesseract\nfrom PIL import Image\n\n# Load image\nimage = Image.open('handwritten_sample.png')\n\n# Perform OCR\ntext = pytesseract.image_to_string(image, config='--psm 6')\nprint(text)