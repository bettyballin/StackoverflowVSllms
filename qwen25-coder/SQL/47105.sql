CREATE VIEW VehicleValueView AS\nSELECT period, NameOfVehicle, Value\nFROM (\n    SELECT period, Truck, Car, Boat\n    FROM YourOriginalTable\n) AS SourceTable\nUNPIVOT (\n    Value FOR NameOfVehicle IN (Truck, Car, Boat)\n) AS UnpivotedTable;