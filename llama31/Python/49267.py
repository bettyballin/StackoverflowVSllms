distinct_users = User.objects.filter(id__in=Model.objects.values_list('watchers', flat=True).distinct())