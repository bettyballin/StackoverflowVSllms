from django.db import models\nfrom django.db.models import Count\n\nclass NonEmptyManager(models.Manager):\n    def get_queryset(self):\n        return super().get_queryset().annotate(\n            num_images=Count('images')\n        ).filter(num_images__gt=0)\n\nclass Portfolio(models.Model):\n    objects = models.Manager()  # The default manager.\n    nonempty = NonEmptyManager()  # The custom manager.\n\n    # Other fields and methods for Portfolio\n\nclass PortfolioImage(models.Model):\n    portfolio = models.ForeignKey(Portfolio, related_name='images', on_delete=models.CASCADE)\n    # Other fields for PortfolioImage