SELECT o.*\nFROM orders o\nJOIN (SELECT DISTINCT user FROM orders ORDER BY RAND()) r ON o.user = r.user\nORDER BY r.user, o.id; -- or another column that defines order per user