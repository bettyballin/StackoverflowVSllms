// Ensure the GMP extension is enabled\n\n// Define your large numbers\n$a = gmp_init('62574');\n$b = gmp_init('62574');\n$mod = gmp_init('104659');\n\n// Perform the multiplication\n$product = gmp_mul($a, $b);\n\n// Perform the modulus operation\n$modulus = gmp_mod($product, $mod);\n\necho "Product: " . gmp_strval($product) . "\n";\necho "Modulus: " . gmp_strval($modulus) . "\n";