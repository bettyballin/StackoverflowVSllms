from django.urls import path\nfrom . import views\n\nurlpatterns = [\n    path('edit/<int:id>/', views.edit, name='edit'),\n    path('edit/', views.edit, name='edit'),\n]