from django.urls import path\nfrom .views import upload_file\n\nurlpatterns = [\n    path('upload/', upload_file, name='upload'),\n]