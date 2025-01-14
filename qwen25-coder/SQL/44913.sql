SELECT o.emp, o.cat, o.date, o.amt, o.cum\nFROM orders o\nJOIN (\n    SELECT emp, cat, MAX(date) AS max_date\n    FROM orders\n    GROUP BY emp, cat\n) latest ON o.emp = latest.emp AND o.cat = latest.cat AND o.date = latest.max_date;