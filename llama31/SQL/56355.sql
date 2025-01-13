CREATE VIEW ApplicationStatus AS\nSELECT \n    ApplicationID,\n    CASE \n        WHEN IsApproved = 1 THEN 1\n        WHEN IsDenied = 1 THEN 2\n        ELSE 0\n    END AS Status\nFROM \n    Applications;