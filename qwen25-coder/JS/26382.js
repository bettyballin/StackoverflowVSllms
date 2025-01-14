function buildList(node) {\n  if (!node.children || node.children.length === 0) return '';\n\n  let ul = document.createElement('ul');\n\n  for (let child of node.children) {\n    let li = document.createElement('li');\n    li.className = child.class;\n    li.textContent = child.title;\n\n    // Recursively add children\n    li.appendChild(buildList(child));\n\n    ul.appendChild(li);\n  }\n\n  return ul;\n}\n\n// Assuming jsonData is your JSON object containing the structure above\nlet parsedData = JSON.parse(jsonData); // If it's a string, parse it to an object\n\nlet htmlList = buildList(parsedData.node);\ndocument.body.appendChild(htmlList);