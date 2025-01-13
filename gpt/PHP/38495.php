<?php\n\n// Define the class for creating IIF files\nclass QuickBooks_IIF\n{\n    private $data = [];\n\n    public function addCustomer($name, $companyName, $address, $phone, $email)\n    {\n        $this->data[] = [\n            'TRNSTYPE' => 'CUST',\n            'NAME' => $name,\n            'COMPANYNAME' => $companyName,\n            'ADDRESS' => $address,\n            'PHONE' => $phone,\n            'EMAIL' => $email\n        ];\n    }\n\n    public function generateIIF()\n    {\n        $iif = "!TRNSTYPE\tNAME\tCOMPANYNAME\tADDRESS\tPHONE\tEMAIL\n";\n        foreach ($this->data as $entry) {\n            $iif .= "{$entry['TRNSTYPE']}\t{$entry['NAME']}\t{$entry['COMPANYNAME']}\t{$entry['ADDRESS']}\t{$entry['PHONE']}\t{$entry['EMAIL']}\n";\n        }\n        return $iif;\n    }\n\n    public function saveToFile($filename)\n    {\n        file_put_contents($filename, $this->generateIIF());\n    }\n}\n\n// Example usage\n$quickBooks = new QuickBooks_IIF();\n$quickBooks->addCustomer('John Doe', 'Doe Inc.', '123 Main St', '555-1234', 'john@doe.com');\n$quickBooks->addCustomer('Jane Smith', 'Smith LLC', '456 Elm St', '555-5678', 'jane@smith.com');\n\n$quickBooks->saveToFile('customers.iif');\n\necho "IIF file generated successfully.";\n\n?>