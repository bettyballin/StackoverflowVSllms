logs = Log.objects.filter(user__in=User.objects.filter(groups__name='accountexec'))