while (/* condition */) {\n       // Fetch and process a limited number of records\n       $records = fetchRecords($limit);\n       foreach ($records as $record) {\n           processRecord($record);\n\n           // Optionally sleep after processing each record\n           usleep(200000); // Sleep for 0.2 seconds\n       }\n   }