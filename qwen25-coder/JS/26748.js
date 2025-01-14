const CryptoJS = require('crypto-js');\n\nfunction encrypt(message, key) {\n    return CryptoJS.AES.encrypt(message, key, {\n        mode: CryptoJS.mode.CBC,\n        padding: CryptoJS.pad.Pkcs7,\n        iv: CryptoJS.lib.WordArray.create([]) // Empty IV for simplicity; match C# IV\n    }).toString();\n}\n\nfunction decrypt(ciphertext, key) {\n    const bytes = CryptoJS.AES.decrypt(ciphertext, key, {\n        mode: CryptoJS.mode.CBC,\n        padding: CryptoJS.pad.Pkcs7,\n        iv: CryptoJS.lib.WordArray.create([]) // Empty IV for simplicity; match C# IV\n    });\n    return bytes.toString(CryptoJS.enc.Utf8);\n}