REST_FRAMEWORK = {\n       'DEFAULT_AUTHENTICATION_CLASSES': (\n           'rest_framework.authentication.TokenAuthentication',\n       ),\n       'DEFAULT_PERMISSION_CLASSES': (\n           'rest_framework.permissions.IsAuthenticated',\n       ),\n   }