$headers = array(\n    "BATCH_TYPE: XML_SINGLE",\n    "BATCH_COUNT: 1",\n    "VENDOR_ID: 53906",\n    "Content-Type: application/xml",\n    "Content-Length: " . strlen($xml_data),\n    "Host: www.example.com"\n);