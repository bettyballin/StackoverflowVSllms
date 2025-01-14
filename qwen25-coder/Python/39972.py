from django.contrib import admin\nfrom .models import YourModel\nfrom .forms import YourModelForm\n\nclass YourModelAdmin(admin.ModelAdmin):\n    form = YourModelForm\n\nadmin.site.register(YourModel, YourModelAdmin)