INSERT INTO purchases (productid, price)\nVALUES (\n  ?,\n  (SELECT price FROM products WHERE id = ?)\n);