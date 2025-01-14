// Example DateTime from SQL Server in UTC\n$utcDateTime = new DateTime('2023-12-31 23:59:59', new DateTimeZone('UTC'));\n\n// Convert to Pacific/Auckland\n$aucklandTimeZone = new DateTimeZone('Pacific/Auckland');\n$utcDateTime->setTimezone($aucklandTimeZone);\n\necho $utcDateTime->format('Y-m-d H:i:s'); // Outputs the converted timestamp