SELECT d.location, d.id\nFROM closing_balance..cb_deposits AS d\nLEFT OUTER JOIN closing_balance..cb_checkbatchhf AS b \n    ON d.id = b.deposit_id AND d.location = b.loc\nLEFT OUTER JOIN closing_balance..cb_checkdf AS c \n    ON b.id = c.batch_id AND b.loc = c.loc\nGROUP BY d.location, d.id\nHAVING SUM(c.check_amt) = b.scanned_subtotal \n    AND SUM(b.scanned_subtotal) = d.amount \n    AND SUM(b.num_checks_scanned) = d.count