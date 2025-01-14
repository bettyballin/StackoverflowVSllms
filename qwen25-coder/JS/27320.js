const bcrypt = require('bcrypt');\n\nasync function hashPassword(password) {\n    const saltRounds = 10;\n    try {\n        const hashedPassword = await bcrypt.hash(password, saltRounds);\n        return hashedPassword;\n    } catch (error) {\n        console.error("Error hashing password:", error);\n        throw error;\n    }\n}