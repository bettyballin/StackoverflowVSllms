CREATE TABLE MovieAttributes (\n    AttributeID INT PRIMARY KEY,\n    AttributeName VARCHAR(50) UNIQUE\n);\n\nINSERT INTO MovieAttributes (AttributeID, AttributeName) VALUES\n(1, 'Director'),\n(2, 'Leading Male'),\n(3, 'Leading Female'),\n(4, 'Villain');