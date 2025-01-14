require_once 'Zend/Search/Lucene.php';\n\n// Assuming you have already loaded your index\n$index = Zend_Search_Lucene::open('/path/to/your/index');\n\nfunction searchItems($queryText) {\n    global $index;\n    // Create a query that searches only in the item fields\n    $queryString = "item-title:$queryText OR item-description:$queryText OR item-tags:$queryText";\n    $hits = $index->find($queryString);\n    return $hits;\n}\n\nfunction searchSellers($queryText) {\n    global $index;\n    // Create a query that searches only in the seller-name field\n    $queryString = "seller-name:$queryText";\n    $hits = $index->find($queryString);\n    return $hits;\n}\n\n// Example usage:\n$userQuery = 'example';\n$searchType = 'items'; // This could be dynamically set based on user selection\n\nif ($searchType === 'items') {\n    $results = searchItems($userQuery);\n} elseif ($searchType === 'sellers') {\n    $results = searchSellers($userQuery);\n}\n\nforeach ($results as $hit) {\n    echo "ID: {$hit->id}\nTitle: {$hit->item_title}\n";\n}