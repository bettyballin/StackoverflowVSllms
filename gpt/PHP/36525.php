// Assuming $SQLarray is your associative array fetched from the database\n$SQLarray = [\n    'user_id' => 1,\n    'block_id' => 2,\n    'b_price' => 100\n];\n\n// Convert associative array to indexed array\n$indexedArray = array_values($SQLarray);\n\n// Output the indexed array\nprint_r($indexedArray);