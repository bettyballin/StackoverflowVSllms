<?php\n\n$csvContent = '"My ""other"" cat", "simple field", "another ""example"""';\n\n// Read one line at a time and parse it using str_getcsv\n$fields = str_getcsv($csvContent);\n\nprint_r($fields);\n?>