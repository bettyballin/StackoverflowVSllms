from django.db import models\n\n     class User(models.Model):\n         name = models.CharField(max_length=100)\n         age = models.IntegerField()\n\n     # In Django, you would typically use Django management commands to interact with the database.