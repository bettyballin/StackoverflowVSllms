INSERT INTO CompanyIDTracker (Company_id)\n   SELECT ID FROM Company ON DUPLICATE KEY UPDATE LastInternalID = 0;