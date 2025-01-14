-- Create the Employee table\nCREATE TABLE Employee(\n    EmployeeID INT PRIMARY KEY IDENTITY,\n    Name VARCHAR(50),\n    ManagerID INT DEFAULT 0,\n    ManagerName VARCHAR(50) DEFAULT ''\n);\n\n-- Insert data into the Employee table\nINSERT INTO Employee(Name, ManagerName) VALUES('Dilbert', 'Boss');\nINSERT INTO Employee(Name, ManagerName) VALUES('Boss', 'Dogbert');\nINSERT INTO Employee(Name) VALUES('Dogbert');\n\n-- Update the ManagerID field with the related EmployeeID\nUPDATE e1\nSET e1.ManagerID = e2.EmployeeID\nFROM Employee e1\nJOIN Employee e2 \nON e1.ManagerName = e2.Name;\n\n-- Select all records to verify the update\nSELECT * FROM Employee;