from flask import Flask\n\n   app = Flask(__name__)\n\n   @app.route('/')\n   def hello_world():\n       return 'Hello, World!'\n\n   if __name__ == '__main__':\n       app.run()