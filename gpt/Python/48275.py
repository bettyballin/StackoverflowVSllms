from django.urls import path\n   from .views import get_geo_data\n\n   urlpatterns = [\n       path('get_geo_data/', get_geo_data, name='get_geo_data'),\n   ]