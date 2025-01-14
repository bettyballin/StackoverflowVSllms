function insertHtmlIntoHead(htmlStr) {\n    var parser = new DOMParser();\n    // Parse the HTML string into a Document object\n    var doc = parser.parseFromString(htmlStr, "text/html");\n    \n    var headElements = doc.head.children;\n    var realHead = document.getElementsByTagName("head")[0];\n    \n    for (var i = 0; i < headElements.length; i++) {\n        var element = headElements[i].cloneNode(true);\n        \n        // Special handling for script elements to ensure they execute\n        if (element.tagName.toLowerCase() === 'script') {\n            var newScript = document.createElement('script');\n            newScript.type = element.type;\n            if (element.src) {\n                newScript.src = element.src;\n            } else {\n                newScript.text = element.text || element.innerHTML; // For IE support\n            }\n            realHead.appendChild(newScript);\n        } else {\n            realHead.appendChild(element);\n        }\n    }\n}\n\n// Example usage:\nvar htmlStr = '<meta charset="UTF-8"><style>body { background-color: lightblue; }</style><script>alert("Hello, this is a script!");</script>';\ninsertHtmlIntoHead(htmlStr);