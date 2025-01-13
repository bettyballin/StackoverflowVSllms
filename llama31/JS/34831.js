function updateSelectOptions() {\n    // Assume 'selectElement' is the SELECT element you're modifying\n    // and 'otherSelection' is the value from another form field\n    // that determines which options are valid\n    \n    var selectElement = document.getElementById('mySelect');\n    var otherSelection = document.getElementById('otherField').value;\n    \n    // Remove all options\n    while (selectElement.options.length > 0) {\n        selectElement.remove(0);\n    }\n    \n    // Populate valid options based on other selection\n    if (otherSelection === 'value1') {\n        addOption(selectElement, 'Option 1', 'value1');\n        addOption(selectElement, 'Option 2', 'value2');\n    } else if (otherSelection === 'value2') {\n        addOption(selectElement, 'Option 3', 'value3');\n        addOption(selectElement, 'Option 4', 'value4');\n    }\n}\n\nfunction addOption(selectElement, text, value) {\n    var option = document.createElement('option');\n    option.text = text;\n    option.value = value;\n    selectElement.add(option);\n}\n\n// Call updateSelectOptions whenever the other selection changes\ndocument.getElementById('otherField').onchange = updateSelectOptions;