CREATE VIEW ApplicationStatus AS\nSELECT \n    ApplicationID,\n    IIF(IsApproved = 1, 'Approved', IIF(IsDenied = 1, 'Denied', 'Pending')) AS Status\nFROM \n    Applications;