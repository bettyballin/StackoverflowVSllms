CREATE TABLE ManufacturerLookup (\n       ManufacturerId INT PRIMARY KEY,\n       Code NVARCHAR(50) NOT NULL UNIQUE, -- Ensure this code is always unique and doesn't change\n       DisplayName NVARCHAR(100)\n   );\n\n   INSERT INTO ManufacturerLookup (ManufacturerId, Code, DisplayName)\n   VALUES (1, 'Nissan', 'Nissan'),\n          (2, 'Toyota', 'Toyota');