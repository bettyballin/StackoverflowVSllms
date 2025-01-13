function validateInput() {\n    let errors = [];\n\n    const email = document.getElementById("email").value;\n    const password = document.getElementById("password").value;\n\n    if (!validateEmail(email)) {\n        errors.push("Invalid email format.");\n    }\n    if (password.length < 8) {\n        errors.push("Password must be at least 8 characters long.");\n    }\n\n    displayErrors(errors);\n    return errors.length === 0;\n}\n\nfunction validateEmail(email) {\n    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;\n    return re.test(email);\n}\n\nfunction displayErrors(errors) {\n    const errorContainer = document.getElementById("error-container");\n    errorContainer.innerHTML = errors.join("<br>");\n}