from bs4 import BeautifulSoup\n\ndef minify_html(html):\n    soup = BeautifulSoup(html, "html.parser")\n    return soup.prettify(formatter="minimal")\n\n# Example usage\nhtml_content = """\n<html>\n  <body>\n    <p>Hello, World!</p> \n  </body>\n</html>\n"""\nminified_html = minify_html(html_content)\nprint(minified_html)