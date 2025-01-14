WITH RankedWorkItems AS (\n    SELECT \n        [System.Id],\n        [System.RevisedDate], \n        [System.Title], \n        [System.State], \n        [System.Reason], \n        [System.CreatedDate], \n        [System.WorkItemType], \n        [System.TeamProject], \n        [Microsoft.VSTS.Scheduling.RemainingWork], \n        [Microsoft.VSTS.Scheduling.CompletedWork], \n        [Microsoft.VSTS.CMMI.Estimate],\n        ROW_NUMBER() OVER (PARTITION BY [System.Id] ORDER BY [System.RevisedDate] DESC) AS rn\n    FROM         \n        WorkItems\n    WHERE     \n        ([System.WorkItemType] = 'Change Request') \n        AND ([System.CreatedDate] >= '2008-09-30') \n        AND ([System.TeamProject] NOT LIKE '%Deleted%')\n        AND ([System.TeamProject] NOT LIKE '%Sandbox%')\n)\nSELECT \n    [System.Id],\n    [System.RevisedDate], \n    [System.Title], \n    [System.State], \n    [System.Reason], \n    [System.CreatedDate], \n    [System.WorkItemType], \n    [System.TeamProject], \n    [Microsoft.VSTS.Scheduling.RemainingWork], \n    [Microsoft.VSTS.Scheduling.CompletedWork], \n    [Microsoft.VSTS.CMMI.Estimate]\nFROM \n    RankedWorkItems\nWHERE \n    rn = 1;