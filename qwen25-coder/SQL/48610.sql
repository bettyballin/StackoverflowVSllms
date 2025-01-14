-- Step 1: Create a temporary list of all nids that need both 'domain_id' and 'domain_site'\nWITH nid_list AS (\n    SELECT DISTINCT nid FROM your_table_name\n),\ndesired_entries AS (\n    SELECT nl.nid, d.realm\n    FROM nid_list nl\n    CROSS JOIN (SELECT 'domain_id' AS realm UNION ALL SELECT 'domain_site') d\n)\n-- Step 2: Find the missing entries\nINSERT INTO your_table_name (nid, realm)\nSELECT de.nid, de.realm\nFROM desired_entries de\nLEFT JOIN your_table_name yt ON de.nid = yt.nid AND de.realm = yt.realm\nWHERE yt.nid IS NULL;