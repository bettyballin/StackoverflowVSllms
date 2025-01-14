function authenticateUser(username, password) {\n    if (verifyPassword(username, password)) {\n        sendOneTimeCode(user.getPhoneNumber());\n        return promptForCodeAndVerify();\n    } else {\n        return "Authentication failed.";\n    }\n}\n\nfunction verifyPassword(username, password) {\n    // Check database for correct credentials\n    return isValid;\n}\n\nfunction sendOneTimeCode(phoneNumber) {\n    generateOneTimeCode(code);\n    sendSMS(phoneNumber, code);\n}\n\nfunction promptForCodeAndVerify() {\n    userInputCode = getUserInput();\n    if (verifyOneTimeCode(userInputCode)) {\n        return "Access granted.";\n    } else {\n        return "Invalid code. Access denied.";\n    }\n}