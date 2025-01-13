WITH BatchTotals AS (\n    SELECT\n        deposit_id,\n        loc,\n        SUM(scanned_subtotal) AS total_scanned_subtotal,\n        SUM(num_checks_scanned) AS total_num_checks_scanned\n    FROM closing_balance..cb_checkbatchhf\n    GROUP BY deposit_id, loc\n),\nCheckTotals AS (\n    SELECT\n        b.deposit_id,\n        b.loc,\n        SUM(c.check_amt) AS total_check_amt\n    FROM closing_balance..cb_checkbatchhf AS b\n    INNER JOIN closing_balance..cb_checkdf AS c\n        ON b.id = c.batch_id AND b.loc = c.loc\n    GROUP BY b.deposit_id, b.loc\n)\nSELECT\n    d.location,\n    d.id\nFROM closing_balance..cb_deposits AS d\nINNER JOIN BatchTotals AS bt\n    ON d.id = bt.deposit_id AND d.location = bt.loc\nINNER JOIN CheckTotals AS ct\n    ON d.id = ct.deposit_id AND d.location = ct.loc\nWHERE\n    ct.total_check_amt = bt.total_scanned_subtotal\n    AND bt.total_scanned_subtotal = d.amount\n    AND bt.total_num_checks_scanned = d.count;