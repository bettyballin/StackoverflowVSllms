SELECT DISTINCT ON (some_field) some_field \n     FROM some_table \n    WHERE some_field LIKE 'text%' \n    ORDER BY some_field \n    LIMIT 10;