// Define the fields to be shown for each select value\n$fieldsToShow = [\n    'option1' => ['field1', 'field2'],\n    'option2' => ['field3', 'field4'],\n    // Add more options as needed\n];\n\n// Convert the PHP array to a JSON object for use in jQuery\n$jsonFieldsToShow = json_encode($fieldsToShow);