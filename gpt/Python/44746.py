# urls.py\nfrom django.urls import path\nfrom .views import ajax_table\n\nurlpatterns = [\n    path('ajax-table/', ajax_table, name='ajax_table'),\n]