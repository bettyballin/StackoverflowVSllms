# myapp/context_processors.py\n\n   def add_user_to_context(request):\n       return {\n           'user': request.user\n       }