ALTER TABLE Payments\nADD CONSTRAINT CHK_PaymentMethod_CardType\nCHECK (\n    (method = 'CC' AND cardType IN ('Visa', 'MasterCard', 'Discover', 'American Express')) OR\n    (method != 'CC' AND cardType IS NULL)\n);