require_once 'IifFileGenerator.php';\n\n$iif = new IifFileGenerator();\n$iif->addCustomer('100', 'CompanyName', 'ContactName');\n$iif->writeFile('output.iif');