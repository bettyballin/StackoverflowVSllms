function passValueToParent(value) {\n    // Code to pass the value from the popup to the parent page\n    window.opener.document.getElementById('yourTextboxId').value = value;\n    window.close();\n}