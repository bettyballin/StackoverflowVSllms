-- Assuming we have a table `items` with columns `id` and `created_at`\n-- Initial fetch for the first page\nSELECT * FROM items\nWHERE created_at < '2023-10-01 00:00:00'\nORDER BY created_at DESC\nLIMIT 10;\n\n-- Fetch the next page using the last `created_at` value from the previous page\nSELECT * FROM items\nWHERE created_at < '2023-09-30 23:59:59' -- replace with the last `created_at` from the previous page\nORDER BY created_at DESC\nLIMIT 10;