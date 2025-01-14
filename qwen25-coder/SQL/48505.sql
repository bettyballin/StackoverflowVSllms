WITH RankedLinks AS (\n    SELECT \n        ptl.ProjectID,\n        ptl.ThingID,\n        ROW_NUMBER() OVER (PARTITION BY ptl.ThingID ORDER BY ptl.CreatedDate DESC) AS rn\n    FROM \n        ProjectThingLink ptl\n)\nSELECT \n    p.ProjectID,\n    p.ProjectName,\n    tl.ThingID,\n    t.ThingName\nFROM \n    RankedLinks rl\nJOIN \n    Project p ON rl.ProjectID = p.ProjectID\nJOIN \n    Thing t ON rl.ThingID = t.ThingID\nWHERE \n    rl.rn = 1;