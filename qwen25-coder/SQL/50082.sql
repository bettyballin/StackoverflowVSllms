UPDATE Facilities_NOID\nSET ID = (\n    SELECT ID \n    FROM Facilities_ID \n    WHERE Facilities_ID.Structure_ID = Facilities_NOID.Structure_ID\n);