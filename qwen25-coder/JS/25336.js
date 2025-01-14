function strpbrk(haystack, charlist) {\n    for (var i = 0; i < haystack.length; ++i) {\n        if (charlist.indexOf(haystack[i]) !== -1) {\n            return true;\n        }\n    }\n    return false;\n}\n\nfunction validatePass() {\n    var oldPass = document.getElementById("oldpass").value;\n    var newPass1 = document.getElementById("newpass1").value;\n    var newPass2 = document.getElementById("newpass2").value;\n\n    if (strpbrk(newPass1, "abcdefghijklmnopqrstuvwxyz")) {\n        document.getElementById("ContainsAtLeastOneLowercaseLetter").innerHTML = "<span id=\"green\">Met</span>";\n    } else {\n        document.getElementById("ContainsAtLeastOneLowercaseLetter").innerHTML = "<span id=\"red\">Not Met</span>";\n    }\n\n    if (strpbrk(newPass1, "ABCDEFGHIJKLMNOPQRSTUVWXYZ")) {\n        document.getElementById("ContainsAtLeastOneUppercaseLetter").innerHTML = "<span id=\"green\">Met</span>";\n    } else {\n        document.getElementById("ContainsAtLeastOneUppercaseLetter").innerHTML = "<span id=\"red\">Not Met</span>";\n    }\n\n    if (strpbrk(newPass1, "1234567890")) {\n        document.getElementById("ContainsAtLeastOneNumber").innerHTML = "<span id=\"green\">Met</span>";\n    } else {\n        document.getElementById("ContainsAtLeastOneNumber").innerHTML = "<span id=\"red\">Not Met</span>";\n    }\n}