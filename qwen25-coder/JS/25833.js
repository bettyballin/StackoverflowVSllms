function isValidTimestamp(timestamp) {\n    const regex = /^\d{4}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]) (\d{2}):([0-5]\d):([0-5]\d)$/;\n    return regex.test(timestamp);\n}\n\nconsole.log(isValidTimestamp("2023/10/05 14:30:00")); // true\nconsole.log(isValidTimestamp("2023/02/29 12:30:00")); // false