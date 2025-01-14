SELECT \n    artranid, \n    trandate, \n    type, \n    checkNumber, \n    refNumber,\n    custid,\n    amount, \n    taxAmount, \n    SUM(amount) OVER (PARTITION BY custid ORDER BY trandate ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS balance,\n    postedflag, \n    modifieddate\nFROM artran\nORDER BY custid, trandate;