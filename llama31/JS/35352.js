// In the child window\nwindow.onbeforeunload = function() {\n  // Set the value to the hidden field in the parent window\n  opener.document.getElementById('hiddenFieldId').value = 'someValue';\n};