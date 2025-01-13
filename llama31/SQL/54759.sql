INSERT INTO CarList (CarColour, CarName, CarCompany)\nSELECT n.CarColour, n.CarName, n.CarCompany\nFROM NewCars n\nWHERE NOT EXISTS (\n    SELECT 1\n    FROM CarList c\n    WHERE c.CarColour = n.CarColour\n    AND c.CarName = n.CarName\n    AND c.CarCompany = n.CarCompany\n)