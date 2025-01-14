import re\n\ndef make_links_clickable(text):\n    # Regex to match URLs that start with http://, https://, or www.\n    url_pattern = re.compile(r'(?<!<img[^>]*?)\b(http://|https://|www\.)\S+\b', re.IGNORECASE)\n    \n    # Function to replace the URLs with <a> tags\n    def replace_url(match):\n        url = match.group(0)\n        if not url.startswith('http'):\n            url = 'http://' + url\n        return f'<a href="{url}">{url}</a>'\n    \n    # Substitute the URLs in the text using the replacement function\n    return url_pattern.sub(replace_url, text)\n\n# Example usage\ntext = """Here is a link: http://example.com and another one www.example.org\nAlso, an image: <img src="http://example.com/image.jpg">"""\nprint(make_links_clickable(text))