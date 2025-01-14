from PyQt5.QtWidgets import QApplication, QTextEdit\nimport xml.dom.minidom\nimport html\n\ndef prettify_xml(xml_string):\n    # Parse and pretty-print XML\n    dom = xml.dom.minidom.parseString(xml_string)\n    pretty_xml_as_string = dom.toprettyxml()\n    return pretty_xml_as_string\n\ndef main():\n    app = QApplication([])\n    text_edit = QTextEdit()\n\n    # Example XML content\n    xml_content = "<root><child1>value1</child1><child2>value2</child2></root>"\n    \n    # Prettify the XML\n    pretty_xml = prettify_xml(xml_content)\n    \n    # Escape XML to be safely included in HTML\n    escaped_xml = html.escape(pretty_xml)\n    \n    # Display in QTextEdit as formatted text\n    html_content = f"<pre style='color: yellow;'>{escaped_xml}</pre>"\n    text_edit.appendHtml(html_content)\n\n    text_edit.show()\n    app.exec_()\n\nif __name__ == "__main__":\n    main()