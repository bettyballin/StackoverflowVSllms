function checkForm() {\n    var name = document.getElementById("FieldData0").value.trim();\n    var email = document.getElementById("FieldData2").value.trim();\n    var question = document.getElementById("FieldData1").value.trim();\n    var category = document.getElementById("FieldData3").value;\n\n    hideAllErrors();\n\n    if (name === "") {\n        document.getElementById("nameError").style.display = "inline";\n        document.getElementById("FieldData0").select();\n        document.getElementById("FieldData0").focus();\n        return false;\n    } else if (!checkEmail(email)) {\n        document.getElementById("emailError2").style.display = "inline";\n        document.getElementById("FieldData2").select();\n        document.getElementById("FieldData2").focus();\n        return false;\n    } else if (category === "") {\n        document.getElementById("categoryError").style.display = "inline";\n        document.getElementById("FieldData3").select();\n        document.getElementById("FieldData3").focus();\n        return false;\n    } else if (question === "") {\n        document.getElementById("questionError").style.display = "inline";\n        document.getElementById("FieldData1").select();\n        document.getElementById("FieldData1").focus();\n        return false;\n    }\n\n    return true; // Only submit the form if all validations pass\n}\n\nfunction checkEmail(email) {\n    var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;\n    return re.test(String(email).toLowerCase());\n}\n\nfunction hideAllErrors() {\n    document.getElementById("nameError").style.display = "none";\n    document.getElementById("emailError2").style.display = "none"; // Corrected ID\n    document.getElementById("categoryError").style.display = "none";\n    document.getElementById("questionError").style.display = "none";\n}