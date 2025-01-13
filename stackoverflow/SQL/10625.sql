SELECT\n    Supplier.SupplierID,\n    COUNT(distinct Computers.ComputerID) as Computers,\n    COUNT(distinct Displays.DisplayID) as Displays,\n    COUNT(distinct Foos.FooID) as Foos,\n    COUNT(distinct Bars.BarID) as Bars\nFROM Supplier\nLEFT OUTER JOIN Computers \n    ON Supplier.SupplierID = Computers.SupplierID\nLEFT OUTER JOIN Displays \n    ON Supplier.SupplierID = Displays.SupplierID\nLEFT OUTER JOIN Foos \n    ON Supplier.SupplierID = Foos.SupplierID\nLEFT OUTER JOIN Bars \n    ON Supplier.SupplierID = Bars.SupplierID\nGROUP BY\n    Supplier.SupplierID