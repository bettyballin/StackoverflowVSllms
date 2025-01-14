CREATE VIEW ApplicationStatus AS\nSELECT \n    ApplicationID,\n    CASE \n        WHEN Approved = 1 THEN 'approved'\n        WHEN Denied = 1 THEN 'denied'\n        ELSE 'pending'\n    END AS Status\nFROM \n    Applications;