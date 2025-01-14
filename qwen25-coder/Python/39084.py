import requests\n\ndef check_proxy(proxy):\n    proxies = {\n        'http': proxy,\n        'https': proxy,\n    }\n    try:\n        response = requests.get('http://httpbin.org/ip', proxies=proxies, timeout=5)\n        if response.status_code == 200:\n            return True\n    except requests.RequestException:\n        pass\n    return False\n\n# Usage\nproxy = "http://your.proxy:port"\nif check_proxy(proxy):\n    print("Proxy is alive")\nelse:\n    print("Proxy is dead")