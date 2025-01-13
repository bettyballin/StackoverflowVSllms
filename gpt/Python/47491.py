from django.db.models import Prefetch\n\npolls = Poll.objects.filter(category='foo').prefetch_related(\n    Prefetch('choice_set', queryset=Choice.objects.all(), to_attr='choices')\n)\n\nfor poll in polls:\n    print(poll.choices)  # This will not perform a SQL query at each iteratio