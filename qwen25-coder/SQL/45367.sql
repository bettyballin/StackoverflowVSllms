LEFT JOIN \n    rate_prices rp_p ON u.rate_package_id = rp_p.rate_id AND /* condition based on weight */\nLEFT JOIN \n    rate_prices rp_d ON u.rate_document_id = rp_d.rate_id  /* condition based on weight */