// Ensure the query string is properly escaped and parsed\n$query = Zend_Search_Lucene_Search_QueryParser::parse($q, 'utf-8');\n\n// Execute the search\n$hits = $index->find($query);