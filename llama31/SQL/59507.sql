DECLARE @from VARCHAR(2) = 'DD'\nDECLARE @to VARCHAR(2) = 'DE'\n\nSELECT *\nFROM vehicles\nWHERE reg_num >= @from AND reg_num < @to + 'ZZZZ'