from django.http import HttpResponse\n\ndef hello_world(request):\n    return HttpResponse("Hello, World!")