from django.db import transaction\n\n     with transaction.atomic():\n         Site.objects.get(name="UnitTest").delete()