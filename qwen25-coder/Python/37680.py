from django.db import models\n\nclass User(models.Model):\n    first_name = models.CharField(max_length=200)\n    last_name = models.CharField(max_length=200)\n    email = models.CharField(max_length=200)\n    password = models.CharField(max_length=200)\n\nclass Idea(models.Model):\n    user = models.ForeignKey(User, on_delete=models.CASCADE)\n    title = models.CharField(max_length=200)\n    description = models.CharField(max_length=255)\n    num_votes = models.IntegerField()