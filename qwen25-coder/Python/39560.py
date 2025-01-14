# handlers/user_handler.py\nimport webapp2\nfrom models.user_model import User  # Import the model\n\nclass UserHandler(webapp2.RequestHandler):\n    def get(self):\n        users = User.all().fetch(10)  # Fetching all users for demonstration\n        self.response.write('Users:\n')\n        for user in users:\n            self.response.write(f'{user.name} - {user.email}\n')