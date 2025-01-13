CREATE VIEW dbo.VIEW_EntityAttributeRelship WITH SCHEMABINDING AS\nSELECT EntityIdNmb \nFROM dbo.EntityAttributeRelship\nWHERE IsActive = 1\nGO\n\nCREATE UNIQUE CLUSTERED INDEX UIX_VIEW_ENTITYATTRIBUTERELSHIP \n  ON dbo.VIEW_EntityAttributeRelship (EntityIdNmb)