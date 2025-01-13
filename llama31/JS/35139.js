const form = document.getElementById('myForm');\nconst requiredFields = ['field1', 'field2', 'field3'];\n\nform.addEventListener('submit', (e) => {\n    let errors = [];\n    \n    requiredFields.forEach((field) => {\n        const input = document.getElementById(field);\n        if (input.value.trim() === '') {\n            errors.push(`${field} is required`);\n        }\n    });\n    \n    if (errors.length > 0) {\n        e.preventDefault(); // prevent form submission\n        // display errors to user\n        errors.forEach((error) => {\n            console.log(error);\n        });\n    }\n});