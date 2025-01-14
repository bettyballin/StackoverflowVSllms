function createHMAC(message, secretKey) {\n    const crypto = require('crypto');\n    return crypto.createHmac('sha256', secretKey).update(message).digest('hex');\n}\n\nconst scoreData = JSON.stringify({ userId: 123, score: 100 });\nconst secretKey = 'yourSecretKey'; // Keep this secure!\nconst hmac = createHMAC(scoreData, secretKey);\n\n// Send both scoreData and hmac to the server