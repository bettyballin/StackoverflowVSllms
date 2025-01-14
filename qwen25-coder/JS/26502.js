const parser = new DOMParser();\n  const xmlDoc = parser.parseFromString("<root><node>Value</node></root>", "application/xml");\n  const nodes = xmlDoc.evaluate('//node', xmlDoc, null, XPathResult.ANY_TYPE, null);\n  let node = nodes.iterateNext();\n  while (node) {\n    console.log(node.textContent); // Outputs: Value\n    node = nodes.iterateNext();\n  }