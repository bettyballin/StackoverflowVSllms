from lxml import etree, html\nfrom io import StringIO\n\ndef validate_html(html_content):\n    parser = html.HTMLParser()\n    try:\n        document = html.fromstring(html_content, parser=parser)\n        print("HTML is well-formed.")\n    except etree.XMLSyntaxError as e:\n        print("HTML is not well-formed.")\n        print("Error: ", e)\n\nhtml_content = """<html>\n<head><title>Sample</title></head>\n<body><h1>Test</h1><p>Paragraph</p></body>\n</html>"""\n\nvalidate_html(html_content)