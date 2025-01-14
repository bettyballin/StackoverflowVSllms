from django.db.models import OuterRef, Subquery, Func, F\n\n# Assuming ProjectFundingDetail has a ForeignKey to Project named 'project'\nlatest_budget_subquery = ProjectFundingDetail.objects.filter(\n    project=OuterRef('pk')\n).order_by('-end_date').values('budget')[:1]\n\nprojects_with_latest_funding_under_1000 = projects_list.annotate(\n    latest_budget=Subquery(latest_budget_subquery)\n).filter(latest_budget__lte=1000)