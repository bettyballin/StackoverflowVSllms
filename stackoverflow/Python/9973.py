import cherrypy\n\nclass HelloWorld(object):\n    def index(self):\n        return "Hello World!"\n    index.exposed = True\n\ncherrypy.quickstart(HelloWorld())