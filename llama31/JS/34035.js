function comparePasswords() {\n    var password = document.getElementById('password').value;\n    var password2 = document.getElementById('password2').value;\n\n    if (password !== password2) {\n        document.getElementById('passwordShow').innerHTML = 'Passwords do not match';\n    } else {\n        document.getElementById('passwordShow').innerHTML = '';\n    }\n}