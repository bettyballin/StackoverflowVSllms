function encode_url($url) {\n  $hash = hash('sha256', $url, true);\n  $encoded = base64_encode($hash);\n  return substr($encoded, 0, 8); // take the first 8 characters\n}\n\nfunction decode_url($encoded) {\n  // Note: Decoding is not possible with this approach, \n  // as we're using a one-way hash function (SHA-256).\n  // You would need to store the original URL in a database \n  // and retrieve it using the encoded string as a key.\n}\n\n// Example usage:\n$url = 'stackoverflow.com/1/';\n$encoded = encode_url($url);\necho $encoded; // e.g. "n3uu399"