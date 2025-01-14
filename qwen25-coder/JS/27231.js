// Example JavaScript validation function\nfunction validateForm() {\n    const xmlHttp = new XMLHttpRequest();\n    xmlHttp.open('GET', 'validation-rules.xml', false);\n    xmlHttp.send(null);\n    const xmlDoc = xmlHttp.responseXML;\n\n    const usernameField = document.getElementById('username');\n    const emailField = document.getElementById('email');\n\n    if (!validateField(usernameField, xmlDoc)) {\n        return false;\n    }\n    if (!validateField(emailField, xmlDoc)) {\n        return false;\n    }\n\n    function validateField(fieldElement, doc) {\n        const fieldRules = doc.evaluate(`//Field[@name="${fieldElement.id}"]/*`, doc.documentElement, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.parentNode;\n\n        if (fieldRules.getElementsByTagName('Required')[0] && !fieldElement.value) {\n            alert(`${fieldElement.id} is required.`);\n            return false;\n        }\n\n        const minLength = fieldRules.getElementsByTagName('MinLength');\n        if (minLength.length > 0 && fieldElement.value.length < parseInt(minLength[0].textContent)) {\n            alert(`${fieldElement.id} must be at least ${minLength[0].textContent} characters long.`);\n            return false;\n        }\n\n        const maxLength = fieldRules.getElementsByTagName('MaxLength');\n        if (maxLength.length > 0 && fieldElement.value.length > parseInt(maxLength[0].textContent)) {\n            alert(`${fieldElement.id} cannot exceed ${maxLength[0].textContent} characters.`);\n            return false;\n        }\n\n        const pattern = fieldRules.getElementsByTagName('Pattern')[0];\n        if (pattern && !new RegExp(pattern.textContent).test(fieldElement.value)) {\n            alert(`${fieldElement.id} does not match required format.`);\n            return false;\n        }\n\n        return true;\n    }\n\n    return true;\n}