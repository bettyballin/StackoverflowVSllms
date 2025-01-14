SELECT \n    CustomerID,\n    Service,\n    ISNULL([CASH], 0) AS Cash,\n    ISNULL([CHECK], 0) AS Check,\n    ISNULL([CREDIT], 0) AS Credit,\n    ISNULL([REMOTE], 0) AS Remote,\n    SUM(SubTotal) AS SubTotal,\n    SUM(Tax) AS Tax,\n    SUM(NetTotal) AS NetTotal\nFROM (\n    SELECT \n        CustomerID,\n        Service,\n        TransType,\n        SubTotal,\n        Tax,\n        NetTotal\n    FROM YourTableName -- Replace with your actual table name\n) AS SourceTable\nPIVOT (\n    SUM(SubTotal)\n    FOR TransType IN ([CASH], [CHECK], [CREDIT], [REMOTE])\n) AS PivotForSubTotal\nLEFT JOIN (\n    SELECT \n        CustomerID,\n        Service,\n        TransType,\n        Tax\n    FROM YourTableName -- Replace with your actual table name\n) AS SourceTableTax\nPIVOT (\n    SUM(Tax)\n    FOR TransType IN ([CASH], [CHECK], [CREDIT], [REMOTE])\n) AS PivotForTax ON PivotForSubTotal.CustomerID = PivotForTax.CustomerID AND PivotForSubTotal.Service = PivotForTax.Service\nLEFT JOIN (\n    SELECT \n        CustomerID,\n        Service,\n        TransType,\n        NetTotal\n    FROM YourTableName -- Replace with your actual table name\n) AS SourceTableNetTotal\nPIVOT (\n    SUM(NetTotal)\n    FOR TransType IN ([CASH], [CHECK], [CREDIT], [REMOTE])\n) AS PivotForNetTotal ON PivotForSubTotal.CustomerID = PivotForNetTotal.CustomerID AND PivotForSubTotal.Service = PivotForNetTotal.Service\nGROUP BY \n    CustomerID, Service,\n    ISNULL([CASH], 0), ISNULL([CHECK], 0), ISNULL([CREDIT], 0),\n    ISNULL([REMOTE], 0)\nORDER BY \n    CustomerID, Service;