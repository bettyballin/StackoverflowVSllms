# backends.py\nfrom django.contrib.auth.backends import ModelBackend\nfrom path.to.middleware import get_current_request\n\nclass CustomBackend(ModelBackend):\n    def get_user(self, user_id):\n        request = get_current_request()\n        if request:\n            session_data = request.session.get('some_key', None)\n            # Use the session data as required\n        # Perform the usual get_user logic\n        try:\n            user = User.objects.get(pk=user_id)\n        except User.DoesNotExist:\n            return None\n        return user