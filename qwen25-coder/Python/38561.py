from django.urls import path\n    from .views import check_session\n\n    urlpatterns = [\n        path('check-session/', check_session, name='check_session'),\n    ]