SELECT RevisionID\n  FROM FileValues\n  WHERE FileID = :file_id AND Value = :target_value;