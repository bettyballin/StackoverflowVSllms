WITH distinct_clients AS (\n    SELECT *, ROW_NUMBER() OVER (PARTITION BY client_id ORDER BY client_id) as rn\n    FROM your_table\n)\nSELECT client_id, employer_id, other_value\nFROM distinct_clients\nWHERE client_id IN (\n    SELECT DISTINCT client_id\n    FROM distinct_clients\n    ORDER BY client_id\n    LIMIT 5\n)\nORDER BY client_id, rn;