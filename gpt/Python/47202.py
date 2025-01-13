import requests\n\nurl = "https://wordclouds.com/api/v1/create"\ndata = {\n    "text": "Hello world! This is a tag cloud example.",\n    "width": 800,\n    "height": 600,\n    "colour": "random-light"\n}\n\nresponse = requests.post(url, data=data)\nif response.status_code == 200:\n    with open("wordcloud.png", "wb") as f:\n        f.write(response.content)\nelse:\n    print("Error:", response.status_code)