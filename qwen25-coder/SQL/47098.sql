-- Example of creating a simple table in MySQL that could represent items in inventory.\n   CREATE TABLE Items (\n     ItemID INT AUTO_INCREMENT PRIMARY KEY,\n     Name VARCHAR(255) NOT NULL,\n     Description TEXT,\n     Price DECIMAL(10, 2) NOT NULL,\n     Stock INT DEFAULT 0\n   );