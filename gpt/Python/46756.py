from django.db import models\n\nclass YourModel(models.Model):\n    id = models.AutoField(primary_key=True)\n    # Define other fields in your model\n    field1 = models.CharField(max_length=255)\n    field2 = models.IntegerField()\n\n    class Meta:\n        db_table = 'your_legacy_table'  # Specify the legacy table name