USE ReportServer;\nGO\n\n-- Assuming you have the existing subscription ID and you want to duplicate it for a new parameter value.\nDECLARE @SubscriptionID UNIQUEIDENTIFIER = 'ExistingSubscriptionID'; -- Replace with your actual subscription ID\nDECLARE @NewLocationParameter NVARCHAR(256) = 'New Location Value'; -- New location parameter value\n\n-- Get the data from existing subscription.\nSELECT \n    SUB.Active,\n    SUB.Description,\n    SUB.EventType,\n    SUB.DeliverBy,\n    SUB.LastStatus,\n    SUB.LastRunTime,\n    Sched.NextRunTime AS NextRunTime,\n    Sched.RecurrenceType,\n    Sched.RecurrencePattern,\n    SETTING.ParameterValues,\n    SETTING.ExtensionSettings\nINTO #SubscriptionData\nFROM dbo.Subscriptions SUB\nINNER JOIN dbo.ReportSchedule RS ON SUB.SubscriptionID = RS.SubscriptionID\nINNER JOIN dbo.Schedule Sched ON RS.ScheduleID = Sched.ScheduleID\nINNER JOIN dbo.SubscriptionSetting SETTING ON SUB.SubscriptionID = SETTING.SubscriptionID\nWHERE SUB.SubscriptionID = @SubscriptionID;\n\n-- Update the parameter values\nUPDATE #SubscriptionData \nSET ParameterValues = REPLACE(ParameterValues, 'OldLocationValue', @NewLocationParameter); -- Replace OldLocationValue with your current default\n\n-- Remove any existing subscriptions that will be replaced,\n-- and insert new ones with updated parameters.\nDELETE dbo.Subscriptions WHERE SubscriptionID = @SubscriptionID;\n\nINSERT INTO dbo.Subscriptions (Report_OID, OwnerId, ModifiedBy, ModifiedDate, Active, Status, DeliveryExtension, Description, EventType, LastStatus, LastRunTime, MatchData)\nSELECT \n    Report_OID, \n    OwnerId, \n    ModifiedBy, \n    ModifiedDate, \n    Active, \n    Status, \n    DeliverBy, \n    Description, \n    EventType, \n    LastStatus, \n    LastRunTime, \n    MatchData\nFROM #SubscriptionData;\n\n-- Insert into report schedule with next run time.\nDECLARE @NewSubscriptionID UNIQUEIDENTIFIER = NEWID();\nINSERT INTO dbo.ReportSchedule (Report_OID, SubscriptionID, ScheduleID)\nSELECT \n    Report_OID, \n    @NewSubscriptionID,\n    ScheduleID\nFROM #SubscriptionData;\n\n-- Insert updated parameters into SubscriptionSetting table.\nINSERT INTO dbo.SubscriptionSetting (ExtensionSettings, ParameterValues, SubscriptionID)\nSELECT \n    ExtensionSettings, \n    ParameterValues, \n    @NewSubscriptionID\nFROM #SubscriptionData;\nGO