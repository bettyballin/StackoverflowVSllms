// Define your search and replace arrays\nvar searchFor = ["quick", "brown", "fox"];\nvar replaceWith = ["nimble", "black", "cat"];\n\n// Function to perform replacements\nfunction replaceTextContent(node) {\n    if (node.nodeType === Node.TEXT_NODE) {\n        // Replace text in each text node\n        for (var i = 0; i < searchFor.length; i++) {\n            var pattern = new RegExp(searchFor[i], 'g'); // Create regex with global flag to replace all occurrences\n            node.textContent = node.textContent.replace(pattern, replaceWith[i]);\n        }\n    } else if (node.nodeType === Node.ELEMENT_NODE) {\n        // Recursively call this function for child nodes\n        for (var j = 0; j < node.childNodes.length; j++) {\n            replaceTextContent(node.childNodes[j]);\n        }\n    }\n}\n\n// Start the replacement from the body of the document\nreplaceTextContent(document.body);