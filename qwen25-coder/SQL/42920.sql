WITH RECURSIVE date_range AS (\n    SELECT MIN(startDate) AS date_start FROM your_start_dates_table\n    UNION ALL\n    SELECT DATE_ADD(date_start, INTERVAL 1 DAY)\n    FROM date_range\n    WHERE date_start < (SELECT MAX(endDate) FROM your_start_dates_table)\n),\nfree_slots AS (\n    SELECT date_start as start_date, DATE_ADD(date_start, INTERVAL 1 WEEK) as end_date\n    FROM date_range dr\n    LEFT JOIN periods p ON NOT (dr.date_start >= p.range_end OR DATE_ADD(dr.date_start, INTERVAL 1 WEEK) <= p.range_start)\n    WHERE p.id IS NULL\n),\nvalid_gaps AS (\n    SELECT fs.start_date, fs.end_date,\n           ROW_NUMBER() OVER(ORDER BY fs.start_date) as row_num\n    FROM free_slots fs\n)\nSELECT vg1.start_date, vg2.end_date\nFROM valid_gaps vg1\nJOIN valid_gaps vg2 ON vg1.row_num + 1 = vg2.row_num AND TIMESTAMPDIFF(SECOND, vg1.end_date, vg2.start_date) <= 0;