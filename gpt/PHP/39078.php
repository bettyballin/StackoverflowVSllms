$signedChar = pack('c', -5);\n   $unsignedChar = pack('C', 250);\n\n   echo bin2hex($signedChar) . PHP_EOL; // Outputs: fb\n   echo bin2hex($unsignedChar) . PHP_EOL; // Outputs: fa