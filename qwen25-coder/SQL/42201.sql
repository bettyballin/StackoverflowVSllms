-- Example of using VARCHAR for flexible-length names\nCREATE TABLE Users (\n    UserID INT PRIMARY KEY,\n    Username VARCHAR(50) UNIQUE NOT NULL\n);