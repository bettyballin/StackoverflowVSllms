CREATE TABLE Employees (\n     EmployeeID INT PRIMARY KEY,\n     Name VARCHAR(100),\n     ManagerID INT,\n     FOREIGN KEY (ManagerID) REFERENCES Employees(EmployeeID)\n   );