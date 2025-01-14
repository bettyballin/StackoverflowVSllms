-- Creating Schemas for different stages\nCREATE SCHEMA Upload;\nCREATE SCHEMA StagingInput;\nCREATE SCHEMA StagingOutput;\nCREATE SCHEMA Audit;\n\n-- Example table creation in each schema\n\n-- Upload Schema - Raw data tables\nCREATE TABLE Upload.RawCustomerData (\n    customer_id INT,\n    name VARCHAR(255),\n    email VARCHAR(100)\n);\n\n-- StagingInput Schema - Basic transformed data\nCREATE TABLE StagingInput.BasicCustomerData (\n    customer_id INT,\n    name VARCHAR(255),\n    email VARCHAR(100),\n    cleaned_email VARCHAR(100) -- example of basic transformation (e.g., lowercasing emails)\n);\n\n-- StagingOutput Schema - Fully prepared data for warehouse\nCREATE TABLE StagingOutput.WarehouseReadyCustomerData (\n    customer_id INT,\n    name VARCHAR(255),\n    clean_email VARCHAR(100),  -- further transformed email field for consumption in the star schema\n    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);\n\n-- Audit Schema - Tracking changes or errors during ETL processes\nCREATE TABLE Audit.CustomerETLAudit (\n    operation_type VARCHAR(50), -- INSERT, UPDATE, DELETE, ERROR\n    record_id INT,\n    old_value TEXT,\n    new_value TEXT,\n    change_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n    error_message TEXT NULL  -- Nullable if no error occurred.\n);