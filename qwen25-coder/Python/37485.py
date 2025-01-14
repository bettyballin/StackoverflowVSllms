# Example using Flask-RESTful\nfrom flask import Flask\nfrom flask_restful import Resource, Api\n\napp = Flask(__name__)\napi = Api(app)\n\nclass HelloWorld(Resource):\n    def get(self):\n        return {'hello': 'world'}\n\napi.add_resource(HelloWorld, '/')\n\nif __name__ == '__main__':\n    app.run(debug=True)