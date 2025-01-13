import base64\n\nwith open("path_to_logo.png", "rb") as image_file:\n    base64_string = base64.b64encode(image_file.read()).decode('utf-8')\n    print(f"data:image/png;base64,{base64_string}")