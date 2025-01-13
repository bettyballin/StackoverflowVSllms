WITH RECURSIVE DateSeries AS (\n    SELECT generate_series('2023-05-01'::date, '2023-05-31'::date, '1 day'::interval) AS day\n),\nAvailability AS (\n    SELECT p.id AS property_id, ds.day\n    FROM Property p\n    CROSS JOIN DateSeries ds\n    LEFT JOIN Booking b ON p.id = b.property_id AND ds.day BETWEEN b.start_date AND b.end_date\n    WHERE b.id IS NULL\n),\nFreeSlots AS (\n    SELECT property_id, day, \n           LAG(day, 2) OVER (PARTITION BY property_id ORDER BY day) AS start_day,\n           LEAD(day, 2) OVER (PARTITION BY property_id ORDER BY day) AS end_day\n    FROM Availability\n)\nSELECT property_id, start_day, end_day\nFROM FreeSlots\nWHERE end_day = day + interval '2 days'\nORDER BY property_id, start_day;