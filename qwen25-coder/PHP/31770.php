$cFormatter = new NumberFormatter('en_US', NumberFormatter::CURRENCY);\n// Set the negative prefix to use minus sign and currency symbol\n$cFormatter->setTextAttribute(NumberFormatter::NEGATIVE_PREFIX, "-\u00A4");\n// Optionally, adjust the negative suffix if needed\n$cFormatter->setTextAttribute(NumberFormatter::NEGATIVE_SUFFIX, "");\n\necho $cFormatter->formatCurrency(123, 'USD'); // Output: "$123.00"\necho $cFormatter->formatCurrency(-456, 'USD'); // Output: "-$456.00"