SELECT\n  CHARGEID,\n  CHARGETYPE,\n  MAX(SERVICEMONTH) AS "MostRecentServiceMonth"\nFROM INVOICE\nGROUP BY CHARGEID, CHARGETYPE