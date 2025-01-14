SELECT \n    s.custid, \n    s.prodid, \n    s.issue, \n    s.qty, \n    s.datesold\nFROM \n    SalesData s\nJOIN (\n    SELECT \n        custid, \n        prodid, \n        MAX(datesold) AS LatestDateSold\n    FROM \n        SalesData \n    WHERE \n        custid = @SpecificCustomerID\n    GROUP BY \n        custid, \n        prodid\n) li ON s.custid = li.custid AND s.prodid = li.prodid AND s.datesold = li.LatestDateSold;