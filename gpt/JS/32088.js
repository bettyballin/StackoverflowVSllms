function getVal(nameOrId) {\n    var element = document.getElementsByName(nameOrId)[0] || document.getElementById(nameOrId);\n\n    if (!element) return null;\n    \n    if (element.type === 'radio') {\n        var radios = document.getElementsByName(nameOrId);\n        for (var i = 0; i < radios.length; i++) {\n            if (radios[i].checked) {\n                return radios[i].value;\n            }\n        }\n        return null;\n    } else if (element.type === 'select-one') {\n        return element.options[element.selectedIndex].value;\n    } else {\n        return element.value;\n    }\n}