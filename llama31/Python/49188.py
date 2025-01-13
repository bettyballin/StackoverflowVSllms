def defang_word(text):\n    search = [\n        b'\xe2\x80\x98'.decode('utf-8'),  # left single quote\n        b'\xe2\x80\x99'.decode('utf-8'),  # right single quote\n        b'\xe2\x80\x9c'.decode('utf-8'),  # left double quote\n        b'\xe2\x80\x9d'.decode('utf-8'),  # right double quote\n        b'\xe2\x80\x93'.decode('utf-8'),  # en dash\n        b'\xe2\x80\x94'.decode('utf-8'),  # em dash\n        b'\x2d'.decode('utf-8')  # hyphen\n    ]\n    replace = [\n        '&lsquo;',\n        '&rsquo;',\n        '&ldquo;',\n        '&rdquo;',\n        '&ndash;',\n        '&mdash;',\n        '&ndash;'\n    ]\n    for i in range(len(search)):\n        text = text.replace(search[i], replace[i])\n    return text\n\n# Example usage:\ntext = input("Paste text from MS Word: ")\nprint(defang_word(text))