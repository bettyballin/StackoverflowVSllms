var cell = document.createElement("td");\ncell.appendChild(document.createTextNode(contents));\ncell.setAttribute('width', '100');\n\n// To make some text smaller you'll need it in a different element like a span\nvar span = document.createElement('span');\nspan.className = 'your-class-for-small-text';\nspan.appendChild(document.createTextNode("Another text"));\n\ncell.appendChild(document.createElement('br'));\ncell.appendChild(span);