# myapp/context_processors.py\nfrom django.contrib.auth.models import User\n\ndef add_user_to_context(request):\n    if request.user.is_authenticated:\n        return {'user': request.user}\n    else:\n        return {}