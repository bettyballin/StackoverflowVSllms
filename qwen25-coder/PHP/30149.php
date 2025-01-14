// An numerical array of associative arrays\n$records = $dbResult->convertToArray();\n\n// Function to extract a column from the records\nfunction getColumn($records, $key) {\n    return array_column($records, $key);\n}\n\n// First sort: Date Completed DESC, Last Name ASC, First Name ASC, Course ASC\narray_multisort(\n    getColumn($records, 'Date Completed'), SORT_DESC,\n    getColumn($records, 'Last Name'), SORT_ASC,\n    getColumn($records, 'First Name'), SORT_ASC,\n    getColumn($records, 'Course'), SORT_ASC,\n    $records\n);\n\n// Now you can perform another sort as needed\narray_multisort(\n    getColumn($records, 'Some Other Field'), SORT_DESC,\n    // Add more sorting criteria if needed\n    $records\n);