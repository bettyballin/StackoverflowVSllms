global $orderDate;\n$orderDate = strftime('%c');\n$orderTimestamp = strtotime($orderDate);\nprint("Order Date: " . date("m/d/y h:i A", $orderTimestamp) . "<br />");