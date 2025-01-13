using System;\nusing System.Xml;\nusing System.Xml.Schema;\nusing System.Xml.XPath;\n\nclass XPathValidator\n{\n    public static bool ValidateXPath(string xpath, XmlSchema schema)\n    {\n        // Create an XPath expression\n        XPathExpression expr = XPathExpression.Compile(xpath);\n\n        // Create an XML schema set\n        XmlSchemaSet schemaSet = new XmlSchemaSet();\n        schemaSet.Add(schema);\n\n        // Create a schema validator\n        XmlSchemaValidator validator = schemaSet.Validators[0];\n\n        // Validate the XPath expression\n        try\n        {\n            validator.Validate(expr);\n            return true;\n        }\n        catch (XmlSchemaValidationException)\n        {\n            return false;\n        }\n    }\n}