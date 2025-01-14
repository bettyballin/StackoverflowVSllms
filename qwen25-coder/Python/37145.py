from django.core.exceptions import ObjectDoesNotExist\n\ntry:\n    group = Group.objects.get(name='blogger')\n    user_dict = {\n        'queryset': User.objects.filter(groups=group)\n    }\nexcept ObjectDoesNotExist:\n    user_dict = {'queryset': User.objects.none()}  # Return an empty queryset if the group does not exist