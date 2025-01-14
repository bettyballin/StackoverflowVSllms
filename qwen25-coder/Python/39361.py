# myapp/context_processors.py\n   def add_auth_to_admin(request):\n       if request.path.startswith('/admin/'):\n           from django.contrib.auth.context_processors import AuthContextProcessor\n           return AuthContextProcessor()(request)\n       return {}