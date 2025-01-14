from http.server import BaseHTTPRequestHandler, HTTPServer\nimport cgi\n\nclass SimpleHTTPRequestHandler(BaseHTTPRequestHandler):\n\n    def do_POST(self):\n        ctype, pdict = cgi.parse_header(self.headers['content-type'])\n        if ctype == 'application/x-www-form-urlencoded':\n            length = int(self.headers['content-length'])\n            postvars = cgi.parse_qs(self.rfile.read(length), keep_blank_values=1)\n            \n            # Extract color value from POST request\n            color_value = postvars[b'color'][0].decode('utf-8')\n            \n            # Process the color value, e.g., send it to microcontroller\n            self.send_response(200)\n            self.end_headers()\n            response = f"Received: {color_value}"\n            self.wfile.write(response.encode())\n\ndef run(server_class=HTTPServer, handler_class=SimpleHTTPRequestHandler, port=8000):\n    server_address = ('', port)\n    httpd = server_class(server_address, handler_class)\n    print(f'Starting httpd on port {port}...')\n    httpd.serve_forever()\n\nif __name__ == '__main__':\n    run()