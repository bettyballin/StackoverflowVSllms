class TABLE(models.Model):\n    id = models.AutoField(primary_key=True)\n    parent = models.ForeignKey('TABLE', null=True, blank=True, on_delete=models.CASCADE, related_name='children')