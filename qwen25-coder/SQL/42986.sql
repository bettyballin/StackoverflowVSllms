-- Step 1: Create the table if not already created\nCREATE TABLE your_table (\n    id NUMBER,\n    name VARCHAR2(50),\n    deleted_date DATE\n);\n\n-- Step 2: Create a function-based index\nCREATE UNIQUE INDEX idx_unique_active_name ON your_table (name)\nWHERE deleted_date IS NULL;\n\n-- This index ensures that the 'name' column values are unique only for rows where deleted_date is null.