-- Example with Aliases\nSELECT u.username, o.order_date\nFROM users AS u\nJOIN orders AS o ON u.user_id = o.customer_id;