SELECT COUNT(*)\nFROM Holiday_XL c\nWHERE c.currency_cd COLLATE SQL_Latin1_General_CP1_CI_AS IN \n      (SELECT DISTINCT h.currency_cd COLLATE SQL_Latin1_General_CP1_CI_AS \n       FROM holiday h)