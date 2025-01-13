-- Assuming your table is named `your_table` and the columns are `column_to_be_unique` and `deleted_date`\n\n-- Step 1: Add a virtual column\nALTER TABLE your_table ADD column_unique_when_not_deleted\n  GENERATED ALWAYS AS (CASE WHEN deleted_date IS NULL THEN column_to_be_unique ELSE NULL END);\n\n-- Step 2: Create a unique index on the virtual column\nCREATE UNIQUE INDEX unique_column_when_not_deleted_idx\n  ON your_table (column_unique_when_not_deleted);