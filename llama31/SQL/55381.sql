SET @n = 5;  -- return the top 5 oldest people\nSELECT * FROM people\nORDER BY age DESC\nLIMIT @n;