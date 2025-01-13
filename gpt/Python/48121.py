from django.db.models import Q\n\n# This will exclude entries where alias is either an empty string or NULL\nnames_with_alias = Name.objects.exclude(Q(alias="") | Q(alias__isnull=True))