# middleware.py\nfrom django.utils import translation\n\nclass DomainLanguageMiddleware:\n    def process_request(self, request):\n        host = request.get_host()\n        tld = host.split(".")[-1]\n        lang_code = None\n        if tld == "fr":\n            lang_code = "fr"\n        elif tld == "de":\n            lang_code = "de"\n        elif tld == "jp":\n            lang_code = "ja"\n        # Add more TLDs and languages as needed\n        if lang_code:\n            translation.activate(lang_code)\n            request.LANGUAGE_CODE = lang_code