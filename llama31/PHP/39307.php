$allowedOrders = array('taco', 'burrito');\nif (in_array($myOrder, $allowedOrders)) {\n    $lunch->{'order_'.$myOrder}();\n} else {\n    // handle invalid order\n}