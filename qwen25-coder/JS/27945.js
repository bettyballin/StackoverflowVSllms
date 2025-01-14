// Using Web Crypto API for generating keys and encryption/decryption\n\nasync function generateKeyPair() {\n    return window.crypto.subtle.generateKey(\n        {\n            name: "RSA-OAEP",\n            modulusLength: 2048, // Can be 1024, 2048, or 4096\n            publicExponent: new Uint8Array([0x01, 0x00, 0x01]),\n            hash: {name: "SHA-256"}\n        },\n        true,\n        ["encrypt", "decrypt"]\n    );\n}\n\nasync function encryptData(publicKey, data) {\n    const encoder = new TextEncoder();\n    return window.crypto.subtle.encrypt(\n        {\n            name: "RSA-OAEP"\n        },\n        publicKey,\n        encoder.encode(data)\n    );\n}\n\nasync function decryptData(privateKey, encryptedData) {\n    const decryptedBuffer = await window.crypto.subtle.decrypt(\n        {\n            name: "RSA-OAEP"\n        },\n        privateKey,\n        encryptedData\n    );\n    return new TextDecoder().decode(decryptedBuffer);\n}\n\n// Usage example\n(async () => {\n    // Generate key pair\n    const keyPair = await generateKeyPair();\n\n    // Data to be encrypted\n    const dataToEncrypt = "This is a secret message.";\n\n    // Encrypt the data\n    const encryptedData = await encryptData(keyPair.publicKey, dataToEncrypt);\n\n    // Decrypt the data\n    const decryptedData = await decryptData(keyPair.privateKey, encryptedData);\n    console.log("Decrypted:", decryptedData);\n})();