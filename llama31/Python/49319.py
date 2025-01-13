import xmlschema\n\n# Load the XML schema\nschema = xmlschema.XMLSchema('path/to/your/schema.xsd')\n\n# Load the XML file\nxml_file = 'path/to/your/xml_file.xml'\n\n# Validate the XML file against the schema\ntry:\n    schema.validate(xml_file)\n    print("XML file is valid")\nexcept xmlschema.XMLSchemaValidationError as e:\n    print("XML file is not valid:")\n    print(e)