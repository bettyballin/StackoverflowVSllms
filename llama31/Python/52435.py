from django.contrib.auth.decorators import permission_required\nfrom .models import MenuItem\n\ndef get_user_menu(request):\n    menu_items = MenuItem.objects.all()\n    user_menu = []\n    for item in menu_items:\n        if request.user.has_perm(item.permission):\n            user_menu.append(item)\n    return user_menu