// Function to execute XPath query and highlight results\nfunction xpathHighlight(xpath) {\n    var nodesSnapshot = document.evaluate(xpath, document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);\n    for (var i=0; i < nodesSnapshot.snapshotLength; i++) {\n        var node = nodesSnapshot.snapshotItem(i);\n        node.style.backgroundColor = 'yellow'; // Highlight the nodes\n    }\n}\n\n// Example usage: replace '//p' with your XPath query\nxpathHighlight('//p');