function getUniqueItemsFromDropdown(dropdownId) {\n    var dropdown = document.getElementById(dropdownId);\n    var items = {};\n    for (var i = 0; i < dropdown.options.length; i++) {\n        items[dropdown.options[i].value] = true;\n    }\n    return Object.keys(items);\n}\n\n// Usage:\nvar uniqueItems = getUniqueItemsFromDropdown('yourDropdownId');\nconsole.log(uniqueItems);