from django.db.models import F, Func\n\nclass ReputationFunc(Func):\n    function = 'reputation'\n    template = '%(function)s(%(expressions)s)'\n\nsorted_queryset = Profile.objects.order_by(ReputationFunc(F('id')))