function castvote(button) {\n  var sel = button.previousElementSibling;  // Get the previous sibling element which is the select tag\n  alert(sel.options[sel.selectedIndex].value);\n}