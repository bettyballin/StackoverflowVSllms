$encryptionKey = 'AE09F72B007CAAB5';\n$password = 'pa55w0rd';\n\n$hash = hash_hmac('sha1', $password, hex2bin($encryptionKey), true);\n$encodedPassword = base64_encode($hash);\n\necho $encodedPassword; // Should output: oK9NOVhpTkxLoLfvh1430SFb5gw=