from django.http import JsonResponse\nfrom django.contrib.auth.decorators import login_required\n\ndef my_ajax_view(request):\n    if not request.user.is_authenticated:\n        return JsonResponse({'error': 'Session expired'}, status=401)\n    \n    # Your existing logic here