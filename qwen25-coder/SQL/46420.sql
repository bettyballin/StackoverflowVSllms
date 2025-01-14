-- Assuming your table is named `items` with columns `id` and `date`\nWITH RankedItems AS (\n    SELECT id, date,\n           RANK() OVER (ORDER BY date) AS rank\n    FROM items\n)\nSELECT prev.id AS previous_id, curr.date AS current_date, next.id AS next_id\nFROM RankedItems curr\nLEFT JOIN RankedItems prev ON curr.rank = prev.rank + 1\nLEFT JOIN RankedItems next ON curr.rank = next.rank - 1\nWHERE curr.date = 'your_date_here';