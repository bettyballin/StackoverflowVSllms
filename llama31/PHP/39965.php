// Create a new product\n$product = Mage::getModel('catalog/product');\n$product->setName('My Service Product');\n$product->setDescription('This is a service product');\n$product->setPrice(10.99);\n$product->setTypeId('service'); // Set product type to "service"\n\n// Save the product\n$product->save();