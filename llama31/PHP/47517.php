foreach ($orders as $order) {\n  foreach ($order->line_items as $lineItem) {\n    if ($lineItem->getType() == 1) {\n      $totalRents++;\n    } else if ($lineItem->getType() == 2) {\n      $totalSales++;\n    }\n  }\n}