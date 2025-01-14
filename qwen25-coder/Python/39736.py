import fitz  # PyMuPDF\n\ndef extract_images_with_positions(pdf_path):\n    document = fitz.open(pdf_path)\n    for page_num in range(len(document)):\n        page = document[page_num]\n        image_list = page.get_images(full=True)\n\n        for img_index, img in enumerate(image_list):\n            xref = img[0]\n            base_image = document.extract_image(xref)\n            image_bytes = base_image["image"]\n            image_ext = base_image["ext"]\n\n            # Save the image\n            with open(f"image{page_num + 1}_{img_index}.{image_ext}", "wb") as img_file:\n                img_file.write(image_bytes)\n\n            # Get image position information\n            bbox = fitz.Rect(img[5:9])  # Bounding box of the image on the page\n            print(f"Page {page_num + 1}: Image{img_index} at x={bbox.x0}, y={bbox.y0}, width={bbox.width}, height={bbox.height}")\n\n# Usage\nextract_images_with_positions("example.pdf")