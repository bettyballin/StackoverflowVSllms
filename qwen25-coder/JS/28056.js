function validateForm() {\n    var formData = {\n        field1: document.getElementById('field1').value,\n        field2: document.getElementById('field2').value\n    };\n\n    // Convert form data to query string format\n    var queryString = Object.keys(formData).map(key => key + '=' + encodeURIComponent(formData[key])).join('&');\n\n    fetch('/yourAction.do?' + queryString, {\n        method: 'POST',\n        headers: {\n            'Content-Type': 'application/x-www-form-urlencoded'\n        }\n    })\n    .then(response => response.text())\n    .then(data => {\n        console.log('Success:', data);\n    })\n    .catch((error) => {\n        console.error('Error:', error);\n    });\n}