CREATE TABLE XmlTable (\n    XmlData xml\n);\n\nINSERT INTO XmlTable (XmlData)\nVALUES (@xmlData);