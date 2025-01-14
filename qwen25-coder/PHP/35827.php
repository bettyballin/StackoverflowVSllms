// Assuming $results is fetched from the database correctly\n$results = array_merge($results, $new_days);\n\n// Create copies of $results\n$a = $results;\n\n// Collect unix times (ensure this doesn't modify original $results)\n$unix_time = array();\nforeach ($results as $row) {\n    $unix_time[] = $row['unix_time'];\n}\n\n// Sort results by $unix_time\narray_multisort($unix_time, SORT_ASC, $results);\n\n// Create another copy of $results (now sorted)\n$b = $results;\n\n// Debugging outputs to check if they are as expected\necho "Original \$a:\n";\nprint_r($a);\necho "\nSorted \$b:\n";\nprint_r($b);