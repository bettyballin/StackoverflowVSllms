# models.py\n   from django.db import models\n\n   class MyModel(models.Model):\n       name = models.CharField(max_length=255)\n       age = models.IntegerField()