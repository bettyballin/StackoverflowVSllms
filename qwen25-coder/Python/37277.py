# urls.py\nfrom django.urls import path\nfrom .views import edit_person\n\nurlpatterns = [\n    path('edit/', edit_person, name='edit_person'),\n    path('edit/<int:person_id>/', edit_person, name='edit_person_with_id'),\n]