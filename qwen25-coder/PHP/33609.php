$queryString = $_GET['search'];\n// Create a boolean OR query\n$finalQuery = Zend_Search_Lucene_QueryParser::parse(\n    '(' . $queryString . ') OR "' . str_replace(' ', '', $queryString) . '"'\n);