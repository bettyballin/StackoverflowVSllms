var links = document.getElementsByTagName('a');\nfor (var i = 0; i < links.length; i++) {\n    if (links[i].className === 'link' && links[i].href.indexOf('233253') !== -1) {\n        links[i].style.display = 'none';\n        break;\n    }\n}