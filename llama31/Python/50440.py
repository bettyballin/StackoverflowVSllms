import unidecode\n\ndef html_to_ascii(html_string):\n    # Convert HTML entities to Unicode\n    unicode_string = html.unescape(html_string)\n    \n    # Convert Unicode to ASCII using unidecode\n    ascii_string = unidecode.unidecode(unicode_string)\n    \n    return ascii_string\n\n# Example usage:\nhtml_string = "&aacute; is an accented character"\nascii_string = html_to_ascii(html_string)\nprint(ascii_string)  # Output: "a is an accented character"