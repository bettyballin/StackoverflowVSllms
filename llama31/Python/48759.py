#!/usr/bin/python\nimport os\nimport sys\nfrom cgi import parse_qs\n\n# Your Python application goes here\ndef app(environ, start_response):\n    start_response('200 OK', [('Content-Type', 'text/plain')])\n    return ['Hello, World!']\n\nif __name__ == '__main__':\n    from flup.server.fcgi import WSGIServer\n    WSGIServer(app).run()