from django.db.models import Q\n\nq = Q()\nfor k,v in d.iteritems():\n        q |= Q(**{'%s__equal' % k: v})\n\nSomeModule.objects.filter(q)