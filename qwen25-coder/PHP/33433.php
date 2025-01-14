function decompressFromBase64($base64EncodedCompressedData) {\n    // Decode the base64 encoded data\n    $binaryData = base64_decode($base64EncodedCompressedData);\n    \n    // Decompress the binary data\n    $decompressedData = gzdecode($binaryData);\n    \n    return $decompressedData;\n}\n\n// Usage example:\n$base64EncodedCompressedData = 'your_base64_encoded_compressed_string_here';\n$data = decompressFromBase64($base64EncodedCompressedData);\n\necho "Decompressed Data:\n";\necho $data;