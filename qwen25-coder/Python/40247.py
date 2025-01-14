from flask import request, Response\n\ndef my_middleware(app):\n    def middleware(environ, start_response):\n        # Request manipulation here\n        response = app(environ, start_response)\n        # Response manipulation here\n        return response\n    return middleware\n\napp.wsgi_app = my_middleware(app.wsgi_app)