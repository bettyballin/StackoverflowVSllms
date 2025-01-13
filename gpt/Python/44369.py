from django.urls import path\nfrom .views import search, pathology\n\nurlpatterns = [\n    path('search/', search, name='search'),\n    path('pathology/', pathology, name='pathology'),\n]