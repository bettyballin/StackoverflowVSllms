from django.conf import settings\nfrom django.conf.urls.static import static\n\n# Existing URL patterns...\nurlpatterns = [\n    # ... other patterns here\n]\n\nif settings.DEBUG:\n    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)