from django.urls import path\n   from .views import MyModelList\n\n   urlpatterns = [\n       path('api/mymodel/', MyModelList.as_view(), name='mymodel-list'),\n   ]