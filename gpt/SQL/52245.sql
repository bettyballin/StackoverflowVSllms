DELETE FROM stock_items\n     WHERE partnr NOT IN (SELECT partnr FROM parts);