import requests\n\nproxy = {\n    "http": "http://your_proxy_server:your_proxy_port",\n    "https": "http://your_proxy_server:your_proxy_port"\n}\n\nresponse = requests.get('http://www.google.com', proxies=proxy)\n\nprint(response.content)