SELECT * FROM search_index WHERE MATCH (word) AGAINST ('$queryString' IN BOOLEAN MODE);