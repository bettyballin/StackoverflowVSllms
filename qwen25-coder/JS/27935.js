function isValidEmail(email) {\n    // Regular expression for validating an Email\n    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;\n    return regex.test(String(email).toLowerCase());\n}\n\n// Example usage:\nconst email = "example@example.com";\nif (isValidEmail(email)) {\n    console.log("Valid email address.");\n} else {\n    console.log("Invalid email address.");\n}