function validateDateTime() {\n    const dateTimeInput = document.getElementById('dateTimeInput').value;\n    const errorMessage = document.getElementById('error-message');\n    const regex = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}$/; // YYYY-MM-DD HH:MM format\n    \n    if (!regex.test(dateTimeInput)) {\n        errorMessage.textContent = 'Invalid date-time format. Please use YYYY-MM-DD HH:MM.';\n    } else {\n        errorMessage.textContent = ''; // Clear the error message\n        // Proceed with form submission or further processing\n    }\n}