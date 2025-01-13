from django.contrib.auth.models import User\n   from django.db import models\n\n   class Favorite(models.Model):\n       user = models.ForeignKey(User, null=True, blank=True, on_delete=models.CASCADE)\n       product = models.ForeignKey(Product, on_delete=models.CASCADE)\n       session_key = models.CharField(max_length=40, null=True, blank=True)