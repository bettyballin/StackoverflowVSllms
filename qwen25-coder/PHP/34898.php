$products = array(array('id' => 1, 'name' => 'Product A'), array('id' => 2, 'name' => 'Product B'));\n   $serializedProducts = serialize($products);\n   // Insert serialized string into a database field