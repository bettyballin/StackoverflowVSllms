document.getElementById('myinput').style.borderStyle = 'none';\nsetTimeout(function() {\n    document.getElementById('myinput').style.removeProperty('border-style');\n}, 0);