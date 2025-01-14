const xmlString = `<root><item id="1">Value1</item><item id="2">Value2</item></root>`;\nconst parser = new DOMParser();\nconst xmlDoc = parser.parseFromString(xmlString, "application/xml");\n\n// Using XPath to find all items with a specific attribute value\nconst xpathResult = xmlDoc.evaluate('//item[@id="1"]', xmlDoc, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);\nconst node = xpathResult.singleNodeValue;\n\nif (node) {\n    console.log(node.textContent); // Output: Value1\n}