distinct_users = Model.objects.values('watchers').distinct()