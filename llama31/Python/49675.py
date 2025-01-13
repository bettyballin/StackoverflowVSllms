from pdf2image import convert_from_path\n\ndef pdf_to_jpeg(pdf_path, jpeg_path):\n    image = convert_from_path(pdf_path)[0]\n    image.save(jpeg_path, "JPEG")\n\n# Example usage:\npdf_path = "input.pdf"\njpeg_path = "output.jpg"\npdf_to_jpeg(pdf_path, jpeg_path)