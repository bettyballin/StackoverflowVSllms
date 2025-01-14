from http.server import BaseHTTPRequestHandler, HTTPServer\n\nclass SimpleHTTPRequestHandler(BaseHTTPRequestHandler):\n    def do_GET(self):\n        self.send_response(200)\n        self.send_header('Content-type', 'text/html')\n        self.end_headers()\n        \n        # HTML response with embedded JavaScript to refresh every 5 seconds\n        html = """\n        <html>\n            <head>\n                <title>Auto Refresh Example</title>\n                <script type="text/javascript">\n                    // Set the timeout period in milliseconds (e.g., 5000ms = 5s)\n                    setTimeout(function(){\n                        location.reload();\n                    }, 5000);\n                </script>\n            </head>\n            <body>\n                <h1>This page refreshes every 5 seconds</h1>\n            </body>\n        </html>\n        """\n        self.wfile.write(html.encode('utf-8'))\n\ndef run(server_class=HTTPServer, handler_class=SimpleHTTPRequestHandler):\n    server_address = ('', 8080)\n    httpd = server_class(server_address, handler_class)\n    print("Serving HTTP on port 8080...")\n    httpd.serve_forever()\n\nif __name__ == '__main__':\n    run()