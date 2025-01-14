def make_request_with_proxy(url, data=None, cookies=None, proxy=None):\n    if proxy:\n        proxies = {\n            'http': proxy,\n            'https': proxy,\n        }\n    else:\n        proxies = None\n\n    try:\n        response = requests.post(url, data=data, cookies=cookies, proxies=proxies)\n        if response.status_code == 200:\n            return response\n        else:\n            print(f"Failed to get a proper response: {response.status_code}")\n    except requests.RequestException as e:\n        print(f"Request failed: {e}")\n\n# Usage\nurl = "http://example.com"\nproxy = "http://your.proxy:port"\ndata = {'key': 'value'}\ncookies = {'session': '123456789'}\n\nresponse = make_request_with_proxy(url, data=data, cookies=cookies, proxy=proxy)\nif response:\n    print("Request successful:", response.text)