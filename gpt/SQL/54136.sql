ALTER TABLE Orders\nADD CONSTRAINT FK_CustomerOrder\nFOREIGN KEY (CustomerID)\nREFERENCES Customers(CustomerID);