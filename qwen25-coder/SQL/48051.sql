-- This is hypothetical syntax reflecting the desired intent.\nALTER TABLE Branch ADD column_is_valid AS \n    CASE WHEN satellite_to_branch_id IS NULL OR \n             NOT EXISTS (SELECT * FROM Branch parent WHERE parent.branch_id = Branch.satellite_to_branch_id AND parent.is_satellite_office = 1)\n         THEN 1 ELSE 0 END PERSISTED\n\nALTER TABLE Branch ADD CONSTRAINT CK_Branch_Recursion CHECK (column_is_valid = 1);