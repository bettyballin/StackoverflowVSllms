import json  # Use the built-in json module instead of django.utils.simplejson\n\nclass YourHandler(webapp2.RequestHandler):\n    def get(self):\n        self.response.headers['Content-Type'] = 'application/json'\n        jsonData = {"foo": "bar"}\n        self.response.write(json.dumps(jsonData))