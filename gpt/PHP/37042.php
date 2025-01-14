<?php\nrequire 'app/Mage.php';\nMage::app();\n\n$orders = Mage::getModel('sales/order')->getCollection()\n    ->addAttributeToSelect('*')\n    ->addAttributeToFilter('status', 'complete');\n\n$csv = fopen('export_orders.csv', 'w');\nfputcsv($csv, ['Order ID', 'Customer Name', 'Shipping Address', 'Shipment Type']);\n\nforeach ($orders as $order) {\n    $shippingAddress = $order->getShippingAddress();\n    $shipmentType = $order->getShippingMethod();\n\n    fputcsv($csv, [\n        $order->getIncrementId(),\n        $order->getCustomerName(),\n        $shippingAddress->format('html'),\n        $shipmentType\n    ]);\n}\n\nfclose($csv);\necho "Orders exported successfully.";