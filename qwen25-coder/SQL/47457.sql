SELECT f.FileName, fv.Value\n  FROM FileValues fv \n  JOIN Files f ON fv.FileID = f.FileID \n  WHERE fv.RevisionID = :revision_id;