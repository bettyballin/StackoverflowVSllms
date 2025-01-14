from bs4 import BeautifulSoup\nimport html\n\ndef extract_text_from_html(html_content):\n    # Parse the HTML content with BeautifulSoup\n    soup = BeautifulSoup(html_content, 'html.parser')\n    \n    # Remove script and style elements\n    for script_or_style in soup(['script', 'style']):\n        script_or_style.decompose()  # Take it out of the document\n    \n    # Get text\n    text = soup.get_text(separator='\n', strip=True)\n    \n    # Decode HTML entities\n    clean_text = html.unescape(text)\n    \n    return clean_text\n\n# Example usage:\nhtml_file_path = 'path_to_your_file.html'\nwith open(html_file_path, encoding='utf-8') as file:\n    html_content = file.read()\n\nplain_text = extract_text_from_html(html_content)\nprint(plain_text)