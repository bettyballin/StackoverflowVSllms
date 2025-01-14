from django.db.models import F, Q\n\n# Using F expression directly in filter\ncars = Car.objects.filter(mileage__lt=F('mileage_limit'))\n\n# Using Q object with F expression\ncars = Car.objects.filter(Q(mileage__lt=F('mileage_limit')))