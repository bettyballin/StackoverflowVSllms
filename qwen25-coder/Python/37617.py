import requests\n\ndef translate_text(text, source_lang, target_lang):\n    url = "https://api.deepl.com/v2/translate"\n    payload = {\n        'auth_key': 'YOUR_DEEPL_AUTH_KEY',\n        'text': text,\n        'source_lang': source_lang,\n        'target_lang': target_lang\n    }\n    response = requests.post(url, data=payload)\n    return response.json()\n\n# Example usage\ntranslated = translate_text("Hello, how are you?", "EN", "ES")\nprint(translated['translations'][0]['text'])