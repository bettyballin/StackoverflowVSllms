import xmlschema\n\n    # Define the XML Schema as a string\n    xsd_string = '''\n    <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">\n        <xs:element name="note">\n            <xs:complexType>\n                <xs:sequence>\n                    <xs:element name="to" type="xs:string"/>\n                    <xs:element name="from" type="xs:string"/>\n                    <xs:element name="heading" type="xs:string"/>\n                    <xs:element name="body" type="xs:string"/>\n                </xs:sequence>\n            </xs:complexType>\n        </xs:element>\n    </xs:schema>\n    '''\n\n    # Define the XML to be validated\n    xml_string = '''\n    <note>\n        <to>Tove</to>\n        <from>Jani</from>\n        <heading>Reminder</heading>\n        <body>Don't forget me this weekend!</body>\n    </note>\n    '''\n\n    # Create an XMLSchema object\n    schema = xmlschema.XMLSchema(xsd_string)\n\n    # Validate the XML\n    try:\n        schema.validate(xml_string)\n        print("XML is valid")\n    except xmlschema.exceptions.XMLSchemaValidationError as e:\n        print(f"XML is invalid: {e}")