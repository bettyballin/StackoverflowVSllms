import xml.etree.ElementTree as etree\n\n# assuming 'element' is your ElementTree element\ninner_html = ''.join(etree.tostring(child, encoding='unicode', method='html') for child in element)\nif element.text:\n    inner_html = element.text + inner_html\nif element.tail:\n    inner_html += element.tail\n\nprint(inner_html)