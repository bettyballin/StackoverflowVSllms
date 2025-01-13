# example using Django ORM\nfrom django.db import models\n\nclass User(models.Model):\n    name = models.CharField(max_length=255)\n\n# fetch users named John\nusers = User.objects.filter(name='John')