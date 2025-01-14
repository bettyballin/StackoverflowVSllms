from bs4 import BeautifulSoup\n\ndef html_to_text(html):\n    soup = BeautifulSoup(html, "html.parser")\n    text = soup.get_text()\n    return text.strip()\n\n# Example usage\nhtml_content = """<b>Hello World.</b><br/><p><i>Is there anyone out there?</i></p>"""\nplain_text = html_to_text(html_content)\nprint(plain_text)  # Output: Hello World. Is there anyone out there?