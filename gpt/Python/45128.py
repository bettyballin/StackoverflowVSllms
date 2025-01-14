from django.db import models\nfrom dirtyfields import DirtyFieldsMixin\n\nclass MyModel(DirtyFieldsMixin, models.Model):\n    field1 = models.CharField(max_length=100)\n    field2 = models.IntegerField()\n\n# Usage example\ninstance = MyModel.objects.get(pk=1)\ninstance.field1 = "new value"\n\nif instance.is_dirty():\n    print("Instance is dirty!")\nelse:\n    print("Instance is not dirty.")