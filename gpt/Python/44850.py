# settings.py\n\nCACHES = {\n    'default': {\n        'BACKEND': 'django.core.cache.backends.redis.RedisCache',\n        'LOCATION': 'redis://127.0.0.1:6379/1',\n    }\n}\n\n# views.py\n\nfrom django.core.cache import cache\nfrom django.shortcuts import render\n\ndef my_view(request):\n    data = cache.get('my_data')\n    if not data:\n        data = expensive_computation()\n        cache.set('my_data', data, timeout=60*15)  # Cache for 15 minutes\n    return render(request, 'my_template.html', {'data': data})