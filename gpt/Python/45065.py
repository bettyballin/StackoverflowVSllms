from django.db import models\n\n    class Category(models.Model):\n        name = models.CharField(max_length=255)\n        parent = models.ForeignKey('self', on_delete=models.CASCADE, null=True, blank=True, related_name='children')\n\n        def __str__(self):\n            return self.name