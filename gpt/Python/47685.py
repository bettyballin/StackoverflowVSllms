from flask import Flask, request, render_template_string\nimport bleach\n\napp = Flask(__name__)\n\n# Define whitelisted domains and their embedding formats\nWHITELISTED_PROVIDERS = {\n    'youtube': 'https://www.youtube.com/embed/',\n    'google_maps': 'https://www.google.com/maps/embed?',\n    # Add more providers as needed\n}\n\n# Allowed HTML tags and attributes\nALLOWED_TAGS = ['iframe']\nALLOWED_ATTRIBUTES = {\n    'iframe': ['src', 'width', 'height', 'frameborder', 'allow', 'allowfullscreen']\n}\n\ndef validate_and_sanitize_embed_code(provider, embed_code):\n    if provider not in WHITELISTED_PROVIDERS:\n        raise ValueError('Unsupported provider')\n\n    # Use bleach to sanitize the embed code\n    sanitized_code = bleach.clean(embed_code, tags=ALLOWED_TAGS, attributes=ALLOWED_ATTRIBUTES)\n\n    # Ensure the src attribute starts with the whitelisted provider URL\n    if not sanitized_code.startswith(f'<iframe src="{WHITELISTED_PROVIDERS[provider]}'):\n        raise ValueError('Invalid embed code')\n\n    return sanitized_code\n\n@app.route('/embed', methods=['POST'])\ndef embed_content():\n    provider = request.form['provider']\n    embed_code = request.form['embed_code']\n\n    try:\n        sanitized_embed_code = validate_and_sanitize_embed_code(provider, embed_code)\n        return render_template_string('<div>{{ embed_code|safe }}</div>', embed_code=sanitized_embed_code)\n    except ValueError as e:\n        return str(e), 400\n\nif __name__ == '__main__':\n    app.run(debug=True)