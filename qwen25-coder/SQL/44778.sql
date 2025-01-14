SELECT \n    Item,\n    SUM(PriceVal) AS Total_PriceVal,\n    SUM(CostVal) AS Total_CostVal,\n    (SUM(CASE WHEN CHARGE_CODE = 'CH' THEN 1 ELSE 0 END) -\n     SUM(CASE WHEN CHARGE_CODE = 'CR' THEN 1 ELSE 0 END)) AS NET_Charges\nFROM \n    Table\nGROUP BY \n    Item;