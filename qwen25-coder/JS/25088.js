// Example of a top-level function\nfunction createUser(username, password) {\n    validateUserInput(username, password);\n    const userId = generateUserId();\n    storeUserInfo(userId, username, hashPassword(password));\n    sendWelcomeEmail(username);\n}\n\n// Example of lower-level functions\nfunction validateUserInput(username, password) {\n    if (!username || !password) throw new Error("Username and password are required.");\n}\n\nfunction generateUserId() {\n    return Date.now().toString(36) + Math.random().toString(36).substr(2, 5);\n}\n\nfunction storeUserInfo(userId, username, hashedPassword) {\n    // Code to store the user data in a database\n    console.log(`User ${username} with id ${userId} created.`);\n}\n\nfunction hashPassword(password) {\n    // Simulate hashing logic\n    return password + "hashed";\n}\n\nfunction sendWelcomeEmail(username) {\n    console.log(`Welcome email sent to ${username}`);\n}