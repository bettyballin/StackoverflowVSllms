from django.db.models import Case, When\n\n# Step 1: Get the sorted list\nsorted_profiles = sorted(Profile.objects.all(), key=lambda p: p.reputation)\n\n# Step 2: Extract the primary keys from the sorted list\nsorted_ids = [profile.id for profile in sorted_profiles]\n\n# Step 3: Create a queryset using the sorted primary keys\npreserved_order = Case(*[When(pk=pk, then=pos) for pos, pk in enumerate(sorted_ids)])\nqueryset = Profile.objects.filter(id__in=sorted_ids).order_by(preserved_order)\n\n# Now 'queryset' can be used in your generic view