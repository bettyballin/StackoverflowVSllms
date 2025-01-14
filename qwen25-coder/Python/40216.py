# urls.py\nfrom django.urls import include, path\nfrom rest_framework.routers import DefaultRouter\nfrom .views import SecurityGuardLocationViewSet\n\nrouter = DefaultRouter()\nrouter.register(r'locations', SecurityGuardLocationViewSet)\n\nurlpatterns = [\n    path('', include(router.urls))\n]