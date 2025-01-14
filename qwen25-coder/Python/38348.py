from bs4 import BeautifulSoup\nimport html\n\ndef clean_html(raw_html):\n    # Parse the HTML with BeautifulSoup\n    soup = BeautifulSoup(raw_html, "html.parser")\n    # Get plain text removing all tags\n    stripped_text = soup.get_text()\n    # Unescape HTML entities\n    cleaned_text = html.unescape(stripped_text)\n    return cleaned_text\n\n# Example usage\nraw_html = "<p>Because regular expressions scare me, I&#39;m trying to find a way to remove all HTML tags and resolve HTML entities from a string in Python.</p>"\ncleaned_text = clean_html(raw_html)\nprint(cleaned_text)