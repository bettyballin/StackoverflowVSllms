import base64\n\npassword = "your_password"\nencoded_password = base64.b64encode(password.encode("utf-8")).decode("utf-8")\nprint(encoded_password)