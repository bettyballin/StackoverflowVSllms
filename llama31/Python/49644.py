from django.contrib.auth.tokens import default_token_generator\n\ndef generate_token(user):\n    return default_token_generator.make_token(user)