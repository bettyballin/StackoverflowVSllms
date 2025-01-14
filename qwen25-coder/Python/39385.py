cache = {}\n\nfunction getRows(whereClause):\n    if whereClause in cache:\n        return cache[whereClause]\n    \n    result = execute_query("SELECT * FROM your_table WHERE " + whereClause)\n    cache[whereClause] = result\n    \n    // Periodically clear or update the cache as needed\n    return result