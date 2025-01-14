// Using short arrow function and list() for array destructuring (PHP >= 7.1)\nlist($value) = [0];\necho $value; // Outputs: 0\n\n// Alternatively using short arrow function directly for single value extraction (PHP >= 7.4)\n$value = ([0])[0];\necho $value; // Outputs: 0