-- Insert product groups\nINSERT INTO ProductGroup (GroupID, GroupName) VALUES (1, 'Ipods');\nINSERT INTO ProductGroup (GroupID, GroupName) VALUES (2, 'TShirts');\n\n-- Insert products\nINSERT INTO Product (ProductID, Name, GroupID) VALUES (1, 'iPod Touch', 1);\nINSERT INTO Product (ProductID, Name, GroupID) VALUES (2, 'iPod Nano', 1);\nINSERT INTO Product (ProductID, Name, GroupID) VALUES (3, 'Cool T-Shirt', 2);\n\n-- Define attributes for Ipods\nINSERT INTO Attribute (AttributeID, GroupID, AttributeName, DataType) VALUES (1, 1, 'capacity', 'INT');\nINSERT INTO Attribute (AttributeID, GroupID, AttributeName, DataType) VALUES (2, 1, 'generation', 'VARCHAR');\n\n-- Define attributes for TShirts\nINSERT INTO Attribute (AttributeID, GroupID, AttributeName, DataType) VALUES (3, 2, 'size', 'VARCHAR');\nINSERT INTO Attribute (AttributeID, GroupID, AttributeName, DataType) VALUES (4, 2, 'color', 'VARCHAR');\n\n-- Insert attribute values for products\nINSERT INTO ProductAttribute (ProductID, AttributeID, Value) VALUES (1, 1, '32');\nINSERT INTO ProductAttribute (ProductID, AttributeID, Value) VALUES (1, 2, '7th');\nINSERT INTO ProductAttribute (ProductID, AttributeID, Value) VALUES (2, 1, '16');\nINSERT INTO ProductAttribute (ProductID, AttributeID, Value) VALUES (2, 2, '5th');\nINSERT INTO ProductAttribute (ProductID, AttributeID, Value) VALUES (3, 3, 'L');\nINSERT INTO ProductAttribute (ProductID, AttributeID, Value) VALUES (3, 4, 'Red');