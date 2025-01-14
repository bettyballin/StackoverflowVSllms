# middleware.py\nfrom django.utils.deprecation import MiddlewareMixin\n\nclass LocaleMiddleware(MiddlewareMixin):\n    def process_request(self, request):\n        host = request.get_host()\n        tld = host.split('.')[-1]\n        # Map TLDs to languages or words\n        language_mappings = {\n            'de': 'Bücher',\n            'fr': 'Livres',\n            'jp': '和書',  # Note: URL encoding might be required\n            'com': 'books'\n        }\n        request.language_word = language_mappings.get(tld, 'books')