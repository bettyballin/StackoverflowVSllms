from django.db import models\n\nclass LegacyModel(models.Model):\n    id = models.AutoField(primary_key=True)\n\n    # Other fields go here...\n\n    class Meta:\n        db_table = 'your_legacy_table_name'  # Ensure this matches the actual table name