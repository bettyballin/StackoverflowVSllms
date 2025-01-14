SELECT \n    `customer`.*, \n    `ca1`.`value1` AS `wedding_date`, \n    `ca2`.`value1` AS `test`\nFROM \n    `customer`\nLEFT JOIN \n    `customer_attributes` AS `ca1` ON customer.customerID = ca1.customerID AND ca1.key1 = 'wedding_date'\nLEFT JOIN \n    `customer_attributes` AS `ca2` ON customer.customerID = ca2.customerID AND ca2.key1 = 'test'\nWHERE \n    customer.customerID = '58029';