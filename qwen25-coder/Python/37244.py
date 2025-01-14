from django.db import models\n\n     class CommonInfo(models.Model):\n         name = models.CharField(max_length=100)\n         age = models.PositiveIntegerField()\n\n         class Meta:\n             abstract = True\n\n     class Student(CommonInfo):\n         home_group = models.CharField(max_length=5)