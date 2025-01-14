INSERT INTO account_type_standard (account_type_Standard_id, tax_status_id, recipient_id)\nSELECT \n    account_type_standard_seq.NEXTVAL,\n    ts.tax_status_id, \n    r.recipient_id\nFROM \n    tax_status ts\nLEFT JOIN \n    recipient r ON r.recipient_code = ?\nWHERE \n    ts.tax_status_code = ?;