CREATE TABLE CustomerEmployee (\n    CustomerId INT NOT NULL,\n    EmployeeId INT NOT NULL,\n    PRIMARY KEY (CustomerId, EmployeeId),\n    FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId),\n    FOREIGN KEY (EmployeeId) REFERENCES Employee(EmployeeId)\n);\n\nALTER TABLE WorkItem\nADD CONSTRAINT FK_WorkItem_CustomerEmployee\nFOREIGN KEY (CustomerId, EmployeeId)\nREFERENCES CustomerEmployee(CustomerId, EmployeeId);