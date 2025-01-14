-- Step 1: Insert data into the new tables if not already done.\n-- Example for Milestones:\nINSERT INTO Milestones (MilestoneID, MilestoneName)\nSELECT NEWID(), MilestoneName\nFROM OldMilestones;\n\n-- Repeat the similar process for Categories, Skills, and PayRates.\n\n-- Step 2: Update Tasks table with new IDs based on names from old schema.\nUPDATE Tasks\nSET TaskID = NEWID(),\n    MilestoneID = (SELECT MilestoneID FROM Milestones WHERE MilestoneName = OldTasks.Milestone),\n    CategoryID = (SELECT CategoryID FROM Categories WHERE CategoryName = OldTasks.Category),\n    SkillID = (SELECT SkillID FROM Skills WHERE SkillName = OldTasks.Skill),\n    RateID = (SELECT RateID FROM PayRates WHERE RateName = OldTasks.PayRate)\nFROM OldTasks;