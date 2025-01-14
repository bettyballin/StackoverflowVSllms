# Fetch all polls with the given category, and prefetch their related choices.\npolls = Poll.objects.filter(category='foo').prefetch_related('choice_set')\n\nfor poll in polls:\n    # Iterating over choices will not hit the database again as they are prefetched.\n    for choice in poll.choice_set.all():\n        print(choice)