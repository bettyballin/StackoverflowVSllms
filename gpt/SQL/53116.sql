SELECT RECNUM, ORDERNUM, CREATEDATE,\n  CASE \n    WHEN str_to_date(concat(expiredate, ' ', year(now())), '%b %d %Y') <= CURDATE()\n    THEN str_to_date(concat(expiredate, ' ', 1 + year(now())), '%b %d %Y')\n    ELSE str_to_date(concat(expiredate, ' ', year(now())), '%b %d %Y')\n  END AS EXPIREDATE,\n  FNAME, LNAME\nFROM test_tmp;