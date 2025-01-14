import base64\n\ndef chunk_split(data, chunk_size=76, separator='\r\n'):\n    encoded_data = base64.b64encode(data).decode('ascii')\n    return separator.join(encoded_data[i:i+chunk_size] for i in range(0, len(encoded_data), chunk_size))\n\n# Example usage\nwith open('picture.jpg', 'rb') as image_file:\n    picture_data = image_file.read()\n\nchunked_base64 = chunk_split(picture_data)\nprint(chunked_base64)