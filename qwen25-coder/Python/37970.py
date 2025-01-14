from django.db import models\n\nclass Subscription(models.Model):\n    user_email = models.EmailField()\n    validation_key = models.CharField(max_length=255, unique=True)\n    is_used = models.BooleanField(default=False)\n\n    def __str__(self):\n        return self.user_email