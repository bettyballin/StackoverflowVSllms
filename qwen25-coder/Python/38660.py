from django.db import models\nfrom django.db.models import Count\n\nclass PortfolioImage(models.Model):\n    portfolio = models.ForeignKey('Portfolio', related_name='images', on_delete=models.CASCADE)\n    # other fields...\n\nclass PortfolioManager(models.Manager):\n    def get_queryset(self):\n        return super().get_queryset()\n\n    def nonempty(self):\n        # Annotate the queryset with the count of images\n        return self.get_queryset().annotate(image_count=Count('images')).filter(image_count__gt=0)\n\nclass Portfolio(models.Model):\n    name = models.CharField(max_length=255)  # Just an example field for completeness\n    objects = PortfolioManager()\n\n    def num_images(self):\n        return self.images.count()