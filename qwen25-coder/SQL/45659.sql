SELECT si.*\n   FROM stock_items si\n   LEFT JOIN parts p ON si.partnr = p.partnumber\n   WHERE p.partnumber IS NULL;