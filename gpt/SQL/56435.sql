ALTER TABLE [Production].[ProductCostHistory] ADD CONSTRAINT \n   [DF_ProductCostHistory_ModifiedDate] DEFAULT (getdate()) FOR [ModifiedDate];\n   GO