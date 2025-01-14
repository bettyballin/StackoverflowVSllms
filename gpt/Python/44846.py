from django.db.models import Q\nimport re\n\ndef search_view(request):\n    soknad_list = Soknad.objects.all()\n\n    var1 = request.GET.get('var1', None)\n    var2 = request.GET.get('var2', None)\n    var3 = request.GET.get('var3', None)\n    search_term = request.GET.get('q', '')\n\n    if var1:\n        soknad_list = soknad_list.filter(pub_date__year=var1)\n\n    if var2:\n        soknad_list = soknad_list.filter(muncipality__name__exact=var2)\n\n    if var3:\n        soknad_list = soknad_list.filter(genre__name__exact=var3)\n\n    # TEXT SEARCH\n    if search_term:\n        stop_word_list = re.compile(STOP_WORDS, re.IGNORECASE)\n        cleaned_search_term = stop_word_list.sub('', search_term).strip()\n        if cleaned_search_term:\n            soknad_list = soknad_list.filter(\n                Q(dream__icontains=cleaned_search_term) |\n                Q(tags__icontains=cleaned_search_term) |\n                Q(name__icontains=cleaned_search_term) |\n                Q(school__name__icontains=cleaned_search_term)\n            )\n\n    return soknad_list  # Or pass this to your context for rendering