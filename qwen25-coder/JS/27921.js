// Instead of using $('div.myClass')\nvar elements = document.getElementsByTagName('div');\nvar myClassElements = [];\nfor (var i = 0; i < elements.length; i++) {\n    if (elements[i].className === 'myClass') {\n        myClassElements.push(elements[i]);\n    }\n}