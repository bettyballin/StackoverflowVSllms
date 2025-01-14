import html\n\ndef convert_html_to_text(html_content):\n    # Convert HTML entities to Unicode string\n    unicode_string = html.unescape(html_content)\n    \n    # Return as UTF-8 encoded bytes if needed, or just return the Unicode string\n    return unicode_string\n\n# Example usage\nhtml_content = "<p>I need to convert &aacute; to its ASCII equivalent.</p>"\nplaintext = convert_html_to_text(html_content)\nprint(plaintext)\n\n# If you specifically need a byte representation (encoded in UTF-8 for email content)\nutf8_encoded_text = plaintext.encode('utf-8')\nprint(utf8_encoded_text)