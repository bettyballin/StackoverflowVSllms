from reportlab.lib.pagesizes import letter\nfrom reportlab.pdfgen import canvas\n\ndef create_pdf(data):\n    c = canvas.Canvas("output.pdf", pagesize=letter)\n    width, height = letter  # keep for later\n\n    c.drawString(100, height - 72, "Title: " + data['title'])\n    c.drawString(100, height - 96, "Author: " + data['author'])\n\n    y_position = height - 132\n    for paragraph in data['content']:\n        if paragraph.startswith("IMAGE:"):\n            # Assuming the path to an image after IMAGE:\n            img_path = paragraph.split(":")[1]\n            c.drawImage(img_path, 100, y_position - 72, 150, 150)  # Adjust dimensions\n            y_position -= 192  # Move down below image\n        else:\n            text_object = c.beginText(100, y_position)\n            text_object.textLine(paragraph)\n            c.drawText(text_object)\n            y_position -= 72\n\n    c.showPage()\n    c.save()\n\n# Example data structure\ndata = {\n    'title': "Document Title",\n    'author': "John Doe",\n    'content': [\n        "This is the first paragraph of text.",\n        "IMAGE: path/to/image.jpg",\n        "This is another paragraph with more content."\n    ]\n}\n\ncreate_pdf(data)