// Assume $byteData is a string containing the binary data (same as your byte array in .NET)\n$byteData = ...; // This needs to be set with the exact same bytes as in .NET\n\n// Calculate SHA1 hash\n$hash = sha1($byteData, true); // The second parameter 'true' makes sha1() return raw 20-byte binary string\n\n// If you need a hexadecimal representation of the hash (like .NET's default)\n$hexHash = bin2hex($hash);\n\necho $hexHash;