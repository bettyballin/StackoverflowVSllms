CREATE INDEX idx_Stock_ProductCode ON Stock(ProductCode);\n   CREATE INDEX idx_Items_ProductCode ON Items(ProductCode);\n   CREATE INDEX idx_Order_CustomerStatus ON Orders(Customer, Status);