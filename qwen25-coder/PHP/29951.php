function createShortHash($input) {\n    // Generate a crc32 hash from the input\n    $hash = crc32($input);\n    \n    // Convert the numeric hash into a base62 encoded string\n    return substr(base_convert($hash, 10, 62), -8); // Get last 8 characters for a fixed length of 8\n}\n\n// Example usage:\n$inputString = "http://example.com/some/long/url";\n$shortHash = createShortHash($inputString);\necho $shortHash;