UPDATE my_table\nSET xml = updateXML(updateXML(xml, '/a/b', '1'), '/a/c', '2')\nWHERE document_id = 123;