function isValidTimestamp(timestamp) {\n    const [datePart, timePart] = timestamp.split(' ');\n    const [year, month, day] = datePart.split('/').map(Number);\n    const [hour, minute, second] = timePart.split(':').map(Number);\n\n    // Adjusting month to be zero-indexed for Date constructor\n    const parsedDate = new Date(year, month - 1, day, hour, minute, second);\n    \n    return (\n        parsedDate.getFullYear() === year &&\n        parsedDate.getMonth() === month - 1 &&\n        parsedDate.getDate() === day &&\n        parsedDate.getHours() === hour &&\n        parsedDate.getMinutes() === minute &&\n        parsedDate.getSeconds() === second\n    );\n}\n\nconsole.log(isValidTimestamp("2023/10/05 14:30:00")); // true\nconsole.log(isValidTimestamp("2023/02/29 12:30:00")); // false