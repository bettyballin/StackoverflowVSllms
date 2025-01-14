from pyzbar.pyzbar import decode\nfrom PIL import Image\n\ndef decode_qr_code(image_path):\n    image = Image.open(image_path)\n    decoded_objects = decode(image)\n    for obj in decoded_objects:\n        print("Type:", obj.type)\n        print("Data:", obj.data.decode("utf-8"))\n\ndecode_qr_code("my_qr.png")