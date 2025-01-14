// Assuming $q is your search query\n$q = '"Sheba Foods"'; // Use double quotes for exact phrase matching\n\ntry {\n    // Parse the query using QueryParser\n    $query = Zend_Search_Lucene_Search_QueryParser::parse($q);\n    \n    // Find hits using parsed query\n    $hits = $index->find($query);\n    \n    // Process hits\n    foreach ($hits as $hit) {\n        // Access document fields\n        echo "Title: " . $hit->title . "\n";\n        echo "URL: " . $hit->url . "\n";\n        // More processing...\n    }\n} catch (Zend_Search_Lucene_Exception $e) {\n    // Handle exceptions\n    echo 'Lucene search error: ' . $e->getMessage();\n}