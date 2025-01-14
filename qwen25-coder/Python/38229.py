import httplib\n\nclass MyConnection:\n    def __init__(self, host, port=None, strict=None, timeout=socket._GLOBAL_DEFAULT_TIMEOUT, source_address=None, ssl=False):\n        self.host = host\n        self.port = port\n        self.ssl = ssl\n        if ssl:\n            self.connection = httplib.HTTPSConnection(host, port, strict, timeout, source_address)\n        else:\n            self.connection = httplib.HTTPConnection(host, port, strict, timeout, source_address)\n\n    def request(self, method, url, body=None, headers={}):\n        self.connection.request(method, url, body, headers)\n\n    def getresponse(self):\n        return self.connection.getresponse()\n\n    # You can add other methods as needed to wrap around the connection object