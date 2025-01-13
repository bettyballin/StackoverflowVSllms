const crypto = require('crypto');\n\n// Shared secret key (replace with a secure value)\nconst K = 'your_secret_key_here';\n\n// Initialize counter ( replace with a secure value)\nconst C = 0;\n\n// Generate authentication token\nfunction generateToken() {\n  const T = Math.floor(Date.now() / (60 * 60 * 1000)); // current hour and minute\n  const hmac = crypto.createHmac('sha256', K);\n  hmac.update(C.toString() + T.toString());\n  return hmac.digest('hex');\n}\n\n// Verify authentication token\nfunction verifyToken(token, counter) {\n  const T = Math.floor(Date.now() / (60 * 60 * 1000)); // current hour and minute\n  const hmac = crypto.createHmac('sha256', K);\n  hmac.update(counter.toString() + T.toString());\n  return hmac.digest('hex') === token;\n}\n\n// Example usage\nconst token = generateToken();\nconsole.log(token);\n\nconst isValid = verifyToken(token, C);\nconsole.log(isValid);