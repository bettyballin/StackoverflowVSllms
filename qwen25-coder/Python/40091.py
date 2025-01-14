from bs4 import BeautifulSoup\n\n# Example malformed HTML content\nc = '''<HTML>\n    <HEAD>\n        <TITLE>Title</TITLE>\n        <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">\n    </HEAD>\n    <BODY>\n        ...\n        ...\n    </BODY>\n</HTML>\n'''\n\n# Use lxml parser which is more forgiving of malformed html\nsoup = BeautifulSoup(c, 'lxml')\n\n# Print the prettified HTML output\nprint(soup.prettify())