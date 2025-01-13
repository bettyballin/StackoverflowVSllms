import httplib\n\nclass MyConnection:\n    def __init__(self, host, use_ssl=False, *args, **kw):\n        self.use_ssl = use_ssl\n        if self.use_ssl:\n            self.connection = httplib.HTTPSConnection(host, *args, **kw)\n        else:\n            self.connection = httplib.HTTPConnection(host, *args, **kw)\n\n    def request(self, method, url, body=None, headers={}):\n        self.connection.request(method, url, body, headers)\n\n    def getresponse(self):\n        return self.connection.getresponse()\n\n# Usage example:\n# For HTTPS connection\nsecure_conn = MyConnection('www.example.com', use_ssl=True)\nsecure_conn.request('GET', '/')\nresponse = secure_conn.getresponse()\nprint(response.status, response.reason)\n\n# For HTTP connection\nnon_secure_conn = MyConnection('www.example.com', use_ssl=False)\nnon_secure_conn.request('GET', '/')\nresponse = non_secure_conn.getresponse()\nprint(response.status, response.reason)