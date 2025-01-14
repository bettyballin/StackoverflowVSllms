SELECT \n    s.day AS splits_day, \n    s.ratio, \n    s.ticker, \n    d.day AS dividends_day, \n    d.amount, \n    d.ticker\nFROM \n    splits s\nFULL OUTER JOIN \n    dividends d ON s.ticker = d.ticker AND s.day = d.day\nORDER BY \n    COALESCE(s.day, d.day), \n    s.ticker;