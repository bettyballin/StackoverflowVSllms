document.getElementById('dateTimeForm').addEventListener('submit', function(event) {\n    event.preventDefault(); // Prevent form submission\n\n    const date = document.getElementById('datePicker').value;\n    const time = document.getElementById('timePicker').value;\n\n    if (isValidDate(date) && isValidTime(time)) {\n        document.getElementById('output').innerText = `Selected Date: ${date}, Selected Time: ${time}`;\n        // Here you would typically send the data to your server\n    } else {\n        alert("Please provide a valid date and time.");\n    }\n});\n\nfunction isValidDate(dateString) {\n    const regex = /^\d{4}-\d{2}-\d{2}$/;\n    if (!regex.test(dateString)) return false;\n\n    const date = new Date(dateString);\n    const year = date.getFullYear();\n    const month = date.getMonth() + 1; // getMonth returns 0-11\n    const day = date.getDate();\n\n    if (date.getFullYear() === year && month < 13 && day < 32) {\n        return true;\n    }\n\n    return false;\n}\n\nfunction isValidTime(timeString) {\n    const regex = /^(?:[01]\d|2[0-3]):[0-5]\d$/; // Match HH:mm in 24h format\n    return regex.test(timeString);\n}