cell.appendChild(document.createTextNode(contents));\ncell.appendChild(document.createElement('br'));\nvar smallText = document.createElement('small');\nsmallText.appendChild(document.createTextNode("Another text"));\ncell.appendChild(smallText);