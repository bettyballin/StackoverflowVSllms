$products = []; // Initialize an empty array outside the loop\n\nwhile ($row = mysql_fetch_row($sqlresult)) {\n    $productId = $row[0]; // Use a variable to hold the product ID\n    $products[$productId] = [\n        'name' => $row[1],\n        'code' => $row[2]\n    ];\n}\n\n// Accessing elements correctly with a variable as key\n$productName = $products[$thisProd]['name'];