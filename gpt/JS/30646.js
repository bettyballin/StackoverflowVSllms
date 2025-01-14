const { DOMParser } = require('xmldom');\nconst xpath = require('xpath');\n\nconst htmlContent = '<html><body><p>Hello World</p></body></html>';\nconst doc = new DOMParser().parseFromString(htmlContent, 'text/html');\nconst nodes = xpath.select('//p/text()', doc);\nconsole.log(nodes[0].nodeValue);  // Output: Hello World