byte[] encryptedBytes = encryptStringToBytes_AES("Hello, World!", yourKey, yourIV);\nstring encryptedString = ByteArrayToString(encryptedBytes);\n\n// Later, to convert it back:\nbyte[] originalBytes = StringToByteArray(encryptedString);\nstring originalText = Encoding.UTF8.GetString(originalBytes); // Assuming UTF-8 encoding