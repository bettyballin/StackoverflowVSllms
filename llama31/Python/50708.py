import requests\n\ndef detect_proxy(request):\n    xff_header = request.headers.get('X-Forwarded-For')\n    if xff_header:\n        # Potential proxy usage detected\n        return True\n    return False