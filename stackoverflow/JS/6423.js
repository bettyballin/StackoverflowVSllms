function getSelectedText(elementId) {\n    var elt = document.getElementById(elementId);\n\n    if (elt.selectedIndex == -1)\n        return null;\n\n    return elt.options[elt.selectedIndex].text;\n}\n\nvar text = getSelectedText('test');