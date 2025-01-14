CREATE TABLE `products` (\n  `product_id` int NOT NULL AUTO_INCREMENT,\n  `name` varchar(255) NOT NULL,\n  PRIMARY KEY (`product_id`)\n);\n\nCREATE TABLE `variations` (\n  `variation_id` int NOT NULL AUTO_INCREMENT,\n  `name` varchar(255) NOT NULL,\n  `kind` varchar(255) DEFAULT NULL,\n  PRIMARY KEY (`variation_id`)\n);\n\nCREATE TABLE `product_variations` (\n  `product_id` int NOT NULL,\n  `variation_id` int NOT NULL,\n  FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`),\n  FOREIGN KEY (`variation_id`) REFERENCES `variations`(`variation_id`)\n);