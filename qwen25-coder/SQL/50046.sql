-- Alter table to add a boolean column\nALTER TABLE user_roles ADD COLUMN is_deleted BOOLEAN DEFAULT FALSE;\n\n-- Index the new column for performance\nCREATE INDEX idx_user_roles_is_deleted ON user_roles(is_deleted);\n\n-- Example query respecting soft delete\nSELECT * FROM user_roles WHERE is_deleted = FALSE;