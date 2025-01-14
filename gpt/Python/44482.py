import requests\nfrom requests_ntlm import HttpNtlmAuth\n\nurl = 'http://example.com'\nproxy = "http://proxy-server:port"\n\nsession = requests.Session()\nsession.proxies = {\n    'http': proxy,\n    'https': proxy,\n}\n\n# Use current Windows credentials\nsession.auth = HttpNtlmAuth('DOMAIN\\username', 'password')\n\nresponse = session.get(url)\nprint(response.text)