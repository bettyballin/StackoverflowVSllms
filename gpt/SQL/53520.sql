CREATE UNIQUE INDEX UX_EntityAttributeRelship_EntityIdNmb_IsActive\nON [dbo].[EntityAttributeRelship] (EntityIdNmb)\nWHERE IsActive = 1;