polls = Poll.objects.filter(category='foo').prefetch_related('choices')\n\nfor poll in polls:\n    for choice in poll.choices.all():\n        print(choice)