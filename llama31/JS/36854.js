function clickHandler(e) {\n    // Assuming you need to pass a value to the server side\n    var valueToPass = 'YourValue';\n    document.getElementById('<%= hdnField.ClientID %>').value = valueToPass;\n    document.getElementById('<%= lnkButton.ClientID %>').click();\n}