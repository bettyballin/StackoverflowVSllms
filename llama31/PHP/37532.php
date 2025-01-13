$var1 = $theArrayValue;\n$chan = explode(',', $var1);\n\n// Filter out non-numeric values (IDs)\n$ids = array_filter($chan, 'is_numeric');\n\n// Convert the IDs to integers to prevent SQL injection\n$ids = array_map('intval', $ids);\n\n// Use the IDs in your query (e.g., DELETE)\n$ids = implode(',', $ids);\n\n// Example query (use prepared statements or parameterized queries for better security)\n$query = "DELETE FROM your_table WHERE id IN ($ids)";