-- Create a calculated member for a velocity range\nWITH \nMEMBER [Measures].[Velocity0to5] AS \n    SUM(\n        IIF([Velocity Dimension].[Velocity].CurrentMember >= 0 AND [Velocity Dimension].[Velocity].CurrentMember <= 5,\n            ([Experiment Fact], [Measures].[Count]),\n            NULL)\n    )\n\nSELECT \n    {\n        [Measures].[Velocity0to5],\n        -- You can add more binned measures here\n    } ON COLUMNS,\n\n    [Experiment Dimension].[Other Experiment Attributes] ON ROWS\n\nFROM [YourCube]