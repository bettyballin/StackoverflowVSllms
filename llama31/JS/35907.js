const selectedNode = document.getElementById('inner1');\nconst siblingNodes = Array.prototype.filter.call(selectedNode.parentNode.childNodes, (node) => node !== selectedNode);\n\nconsole.log(siblingNodes); // outputs: [div#inner2, div#inner3, div#inner4]