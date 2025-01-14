SELECT *\nFROM YourTable\nWHERE StartDate <= CURRENT_DATE AND \n      COALESCE(EndDate, DATE '9999-12-31') >= CURRENT_DATE;