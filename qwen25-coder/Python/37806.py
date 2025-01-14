# Example of making sure UserProfile is created with a user\n   from django.contrib.auth.models import User\n   from myapp.models import UserProfile\n\n   def create_user(username='testuser', password='password123'):\n       user = User.objects.create_user(username=username, password=password)\n       UserProfile.objects.create(user=user)\n       return user