CREATE TABLE IPv6Addresses (\n    AddressID INT PRIMARY KEY IDENTITY,\n    UpperBits BIGINT NOT NULL,\n    LowerBits BIGINT NOT NULL\n);