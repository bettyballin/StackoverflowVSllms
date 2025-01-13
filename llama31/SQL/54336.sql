CREATE TABLE CustomerProductCodeHandlers (\n  CustomerProductId INT,\n  CustomCodeHandlerId INT,\n  PRIMARY KEY (CustomerProductId, CustomCodeHandlerId),\n  FOREIGN KEY (CustomerProductId) REFERENCES CustomerProducts(Id),\n  FOREIGN KEY (CustomCodeHandlerId) REFERENCES CustomCodeHandlers(Id)\n);