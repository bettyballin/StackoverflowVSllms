// Try using odbc_fetch_row() instead of odbc_fetch_array()\n$counter = 0;\nwhile(odbc_fetch_row($result)) {\n    //Insert into MySQL using Zend Framework\n    $counter++;\n}\necho $counter;