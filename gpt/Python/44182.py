from lxml import etree\n\nxml = """\n<root xmlns:ns="http://example.com/ns">\n    <html xmlns="http://www.w3.org/1999/xhtml">\n        <body>\n            <p>Content of body</p>\n        </body>\n    </html>\n    <ns:element>\n        <ns:child>Content of namespaced element</ns:child>\n    </ns:element>\n</root>\n"""\n\ntree = etree.fromstring(xml)\n\n# Register namespaces\nnamespaces = {\n    'xhtml': 'http://www.w3.org/1999/xhtml',\n    'ns': 'http://example.com/ns'\n}\n\n# XPath query\nxpath_query = "//*[namespace-uri()='http://www.w3.org/1999/xhtml' and local-name()='body'] | //*[namespace-uri()='http://example.com/ns' and position()=1]"\nelements = tree.xpath(xpath_query, namespaces=namespaces)\n\nfor element in elements:\n    print(etree.tostring(element, pretty_print=True).decode())