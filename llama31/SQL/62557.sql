BEGIN TRY\n    SELECT * INTO target_table FROM source_table;\nEND TRY\nBEGIN CATCH\n    IF ERROR_NUMBER() = 3723  -- schema changed error\n        -- handle the error, e.g., by re-creating the target table\nEND CATCH