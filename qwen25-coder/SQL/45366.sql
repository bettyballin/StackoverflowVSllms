SELECT \n    i.invoice_id,\n    i.user_id,\n    i.invoice_type,\n    CASE \n        WHEN i.invoice_type = 'package' THEN rp_p.price \n        WHEN i.invoice_type = 'package' THEN rp_d.price \n    END AS price\nFROM \n    invoices i\nJOIN \n    users u ON i.user_id = u.user_id\nLEFT JOIN \n    rate_prices rp_p ON u.rate_package_id = rp_p.rate_id AND /* add conditions for weight if necessary */\nLEFT JOIN \n    rate_prices rp_d ON u.rate_document_id = rp_d.rate_id  /* add conditions for weight if necessary */   \nWHERE \n    i.invoice_type IN ('package', 'document')