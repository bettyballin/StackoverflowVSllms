ames_with_alias = Name.objects.filter(~Q(alias="") & ~Q(alias__isnull=True))