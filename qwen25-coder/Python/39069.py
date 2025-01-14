from django.db.models import Sum, F\nfrom django.db.models.functions import ExtractDay, ExtractMonth, ExtractYear\n\ndata = My_Model.objects.annotate(\n    month=ExtractMonth('time_stamp'),\n    day=ExtractDay('time_stamp'),\n    year=ExtractYear('time_stamp')\n).values('month', 'day', 'year').annotate(\n    the_date=F('year') * 10000 + F('month') * 100 + F('day'),\n    total_numbers_data=Sum('numbers_data')\n).order_by('the_date')