function validatePass() {\n    var oldPass = document.getElementById("oldpass").value;\n    var newPass1 = document.getElementById("newpass1").value;\n    var newPass2 = document.getElementById("newpass2").value;\n\n    if (/[a-z]/.test(newPass1)) {\n        document.getElementById("ContainsAtLeastOneLowercaseLetter").innerHTML = "<span id=\"green\">Met</span>";\n    } else {\n        document.getElementById("ContainsAtLeastOneLowercaseLetter").innerHTML = "<span id=\"red\">Not Met</span>";\n    }\n\n    if (/[A-Z]/.test(newPass1)) {\n        document.getElementById("ContainsAtLeastOneUppercaseLetter").innerHTML = "<span id=\"green\">Met</span>";\n    } else {\n        document.getElementById("ContainsAtLeastOneUppercaseLetter").innerHTML = "<span id=\"red\">Not Met</span>";\n    }\n\n    if (/\d/.test(newPass1)) {\n        document.getElementById("ContainsAtLeastOneNumber").innerHTML = "<span id=\"green\">Met</span>";\n    } else {\n        document.getElementById("ContainsAtLeastOneNumber").innerHTML = "<span id=\"red\">Not Met</span>";\n    }\n}