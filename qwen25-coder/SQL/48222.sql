-- Assuming you have access to the catalog database and are familiar with SSRS stored procedures\nEXEC ReportServer.dbo.AddSubscription \n    @Report = '/YourFolder/YourReport',\n    @ExtensionSettings = '<ParameterValues><ParameterValue><Name>TO</Name><Value>you@example.com</Value></ParameterValue>' +\n                         '<ParameterValue><Name>Cc</Name><Value></Value></ParameterValue>' +\n                         '<ParameterValue><Name>Bcc</Name><Value></Value></ParameterValue>' +\n                         '<ParameterValue><Name>Subject</Name><Value>Your Report Subject</Value></ParameterValue>' +\n                         '<ParameterValue><Name>Comment</Name><Value>Here is your report.</Value></ParameterValue></ParameterValues>',\n    @Description = 'Email Subscription',\n    @ActiveEndDate = NULL,\n    @ActiveStartTime = GETDATE(),\n    @EventType = 'TimedSubscription',\n    @MatchData = '<ScheduleDefinition>' +\n                 '<WeeklyRecurrence><WeeksInterval>1</WeeksInterval>' +\n                 '</WeeklyRecurrence></ScheduleDefinition>',\n    @DeliveryExtension = 'Report Server Email',\n    @ParameterValues = NULL,\n    @DataTypeSettings = NULL,\n    @OwnerIDString = SUSER_SID(),\n    @Format = '<DeviceInfo><StreamRoot>/Some/Folder/Location/</StreamRoot><Extension>PDF</Extension></DeviceInfo>';