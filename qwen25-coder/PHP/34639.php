$searchTerm = urldecode($_REQUEST['term']);\n    $searchTerm = preg_replace('/[^a-zA-Z0-9%\s]/', '', $searchTerm);