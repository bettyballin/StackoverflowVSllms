SELECT * FROM content_items WHERE MATCH (content, name) AGAINST ('+".preg_replace('/\s+/', ' +', $searchTerm)."' IN BOOLEAN MODE)