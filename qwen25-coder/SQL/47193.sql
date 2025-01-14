-- Table Structure for Hierarchical Path Enumeration\nCREATE TABLE Facilities (\n    FacilityID INT PRIMARY KEY,\n    UpstreamPath VARCHAR(MAX) -- This stores the path from root node to this facility\n);\n\n-- Example INSERT statement\nINSERT INTO Facilities (FacilityID, UpstreamPath)\nVALUES\n(1, '/'),                 -- Root node\n(2, '/1/'),              -- Upstream node of 1\n(3, '/1/'),              -- Upstream node of 1\n(4, '/2/'),              -- Upstream node of 2\n(5, '/2/3/'),             -- Upstream nodes of both 2 and 3\n-- Add more facilities as needed\n;\n\n-- Query to find all upstream facilities for a given facility (e.g., FacilityID = 5)\nSELECT * \nFROM Facilities f\nWHERE CHARINDEX(f.UpstreamPath, (\n    SELECT UpstreamPath + CAST(FacilityID AS VARCHAR) + '/'\n    FROM Facilities root\n    WHERE FacilityID = 5 -- Replace with the target facility ID\n)) > 0;