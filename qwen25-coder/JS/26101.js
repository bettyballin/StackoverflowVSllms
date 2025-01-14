function decrypt(encrypted) {\n    var password = "YourSecretPassword"; // Must match PHP password\n    var decoded = CryptoJS.enc.Base64.parse(encrypted);\n    var iv = decoded.clamp(0, 16);          // extract iv from encrypted text\n    var hmac = decoded.words.slice(4, 8);   // extract hmac from encrypted text\n    var ciphertext = decoded.words.slice(8);  // remove iv and hmac parts\n\n    // convert words arrays to byte arrays for processing with CryptoJS AES decryption\n    ciphertext.sigBytes = ciphertext.words.length * 4;\n    hmac.sigBytes = hmac.words.length * 4;\n\n    var decryptedRaw = CryptoJS.AES.decrypt(\n        { ciphertext: ciphertext },\n        CryptoJS.enc.Utf8.parse(password),\n        {\n            iv: iv,\n            padding: CryptoJS.pad.NoPadding\n        }\n    ).toString(CryptoJS.enc.Utf8);\n\n    // Verify HMAC before returning decrypted data\n    var calculatedHmac = CryptoJS.HMAC(CryptoJS.SHA256, decryptedRaw, password).toString();\n    if (calculatedHmac === hmac.toString())\n        return decryptedRaw;\n\n    throw new Error("Data integrity check failed");\n}\n\ndocument.body.innerHTML += decrypt('<?php echo $encryptedForm; ?>');