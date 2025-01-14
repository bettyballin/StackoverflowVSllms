// Assuming $subtotal, $shipping, and $exchangeRate are decimal numbers\n$subtotal = 9.75;\n$shipping = 5.95;\n$totalInBaseCurrency = $subtotal + $shipping;\n\n// Use BCMath for arbitrary precision arithmetic\n$convertedSubtotal = bcadd($subtotal * $exchangeRate, 0, 2);\n$convertedShipping = bcadd($shipping * $exchangeRate, 0, 2);\n\n// Calculate total after rounding each component separately\n$totalInForeignCurrency = bcadd($convertedSubtotal, $convertedShipping, 2);\n\n// Store the base currency totals and foreign currency totals in your order processing system\n$orderDetails = [\n    'subtotal_in_base_currency' => $subtotal,\n    'shipping_in_base_currency' => $shipping,\n    'total_in_base_currency' => $totalInBaseCurrency,\n    'subtotal_in_foreign_currency' => $convertedSubtotal,\n    'shipping_in_foreign_currency' => $convertedShipping,\n    'total_in_foreign_currency' => $totalInForeignCurrency,\n    'currency_code' => 'EUR', // Example currency code\n    'exchange_rate' => $exchangeRate,\n];\n\n// Display to the user or template\necho "Subtotal: " . $convertedSubtotal . "\n";\necho "Shipping: " . $convertedShipping . "\n";\necho "Total: " . $totalInForeignCurrency . "\n";