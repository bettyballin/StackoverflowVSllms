function isValidDateInRange(requestedDate) {\n    const date = new Date(requestedDate);\n    const now = new Date();\n    \n    // Get the current day of the week (0-6, Sunday-Saturday)\n    const currentDay = now.getDay();\n    \n    // Calculate the date of the next Monday\n    const nextMonday = new Date(now);\n    nextMonday.setDate(now.getDate() + (1 + 7 - currentDay) % 7);\n    \n    // Calculate the date of the next Friday\n    const nextFriday = new Date(nextMonday);\n    nextFriday.setDate(nextMonday.getDate() + 4);\n\n    // Check if requestedDate is within the range\n    return date >= nextMonday && date <= nextFriday;\n}\n\n// Example usage:\nconst requestedDate = '2023-10-16'; // Example date\nconst isValid = isValidDateInRange(requestedDate);\nconsole.log(isValid); // Output: true or false depending on the date