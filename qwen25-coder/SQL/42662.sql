SELECT * FROM your_table_name\nORDER BY some_column -- Ensure you have an order criterion\nLIMIT 100 OFFSET (page_number - 1) * 100;