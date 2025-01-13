from BaseHTTPServer import BaseHTTPRequestHandler, HTTPServer\nimport json\n\nclass AjaxRequestHandler(BaseHTTPRequestHandler):\n    def do_POST(self):\n        content_length = int(self.headers['Content-Length'])\n        body = self.rfile.read(content_length)\n        data = json.loads(body)\n\n        # Process the data\n        response = {'message': 'Hello, ' + data['name'] + '!'}\n\n        self.send_response(200)\n        self.send_header('Content-type', 'application/json')\n        self.end_headers()\n        self.wfile.write(json.dumps(response))\n\ndef run_server(server_class=HTTPServer, handler_class=AjaxRequestHandler):\n    server_address = ('', 8000)\n    httpd = server_class(server_address, handler_class)\n    print 'Starting httpd...'\n    httpd.serve_forever()\n\nif __name__ == "__main__":\n    run_server()