from wsgiref.simple_server import make_server\n\n   def simple_app(environ, start_response):\n       status = '200 OK'\n       headers = [('Content-type', 'text/plain; charset=utf-8')]\n       start_response(status, headers)\n       return [b"Hello World"]\n\n   with make_server('', 8000, simple_app) as httpd:\n       print("Serving on port 8000...")\n       httpd.serve_forever()