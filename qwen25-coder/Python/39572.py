#!/usr/bin/python3\n\nimport sys\nsys.stdout.write("Content-Type: text/html\n\n")\nimport cherrypy\n\nclass HelloWorld:\n    @cherrypy.expose\n    def index(self):\n        return "Hello World!"\n\nif __name__ == '__main__':\n    conf = {\n        '/': {\n            'tools.sessions.on': True,\n        }\n    }\n    cherrypy.quickstart(HelloWorld(), '/', conf)