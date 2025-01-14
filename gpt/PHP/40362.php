<?php\n// Ensure the BCMath extension is available\nif (!extension_loaded('bcmath')) {\n    die('BCMath extension is not loaded.');\n}\n\n// Set the precision\nbcscale(2);\n\n// Example monetary values\n$value1 = '1234.56';\n$value2 = '789.10';\n\n// Addition\n$sum = bcadd($value1, $value2);\necho "Sum: $sum\n"; // Output: Sum: 2023.66\n\n// Subtraction\n$difference = bcsub($value1, $value2);\necho "Difference: $difference\n"; // Output: Difference: 445.46\n\n// Multiplication\n$product = bcmul($value1, '2');\necho "Product: $product\n"; // Output: Product: 2469.12\n\n// Division\n$quotient = bcdiv($value1, '2');\necho "Quotient: $quotient\n"; // Output: Quotient: 617.28\n\n// Comparisons\nif (bccomp($value1, $value2) == 1) {\n    echo "$value1 is greater than $value2\n";\n} elseif (bccomp($value1, $value2) == -1) {\n    echo "$value1 is less than $value2\n";\n} else {\n    echo "$value1 is equal to $value2\n";\n}\n?>