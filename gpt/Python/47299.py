from django.contrib import admin\n   from .models import CustomUser, Role\n\n   admin.site.register(CustomUser)\n   admin.site.register(Role)