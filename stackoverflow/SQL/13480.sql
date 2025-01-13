CREATE TABLE [dbo].[StandardSchedule](\n    [scheduledate] [datetime] NOT NULL,\n    [shift] [varchar](25) NOT NULL,\n CONSTRAINT [PK_StandardSchedule] PRIMARY KEY CLUSTERED \n( [scheduledate] ASC ));\n\nCREATE TABLE [dbo].[HolidaySchedule](\n    [holidaydate] [datetime] NOT NULL,\n    [shift] [varchar](25) NOT NULL,\n CONSTRAINT [PK_HolidaySchedule] PRIMARY KEY CLUSTERED \n( [holidaydate] ASC ));\n\nCREATE TABLE [dbo].[ExceptionSchedule](\n    [exceptiondate] [datetime] NOT NULL,\n    [shift] [varchar](25) NOT NULL,\n CONSTRAINT [PK_ExceptionDate] PRIMARY KEY CLUSTERED \n( [exceptiondate] ASC ));\n\nINSERT INTO ExceptionSchedule VALUES ('2008.01.06', 'ExceptionShift1');\nINSERT INTO ExceptionSchedule VALUES ('2008.01.08', 'ExceptionShift2');\nINSERT INTO ExceptionSchedule VALUES ('2008.01.10', 'ExceptionShift3');\nINSERT INTO HolidaySchedule VALUES ('2008.01.01', 'HolidayShift1');\nINSERT INTO HolidaySchedule VALUES ('2008.01.06', 'HolidayShift2');\nINSERT INTO HolidaySchedule VALUES ('2008.01.09', 'HolidayShift3');\nINSERT INTO StandardSchedule VALUES ('2008.01.01', 'RegularShift1');\nINSERT INTO StandardSchedule VALUES ('2008.01.02', 'RegularShift2');\nINSERT INTO StandardSchedule VALUES ('2008.01.03', 'RegularShift3');\nINSERT INTO StandardSchedule VALUES ('2008.01.04', 'RegularShift4');\nINSERT INTO StandardSchedule VALUES ('2008.01.05', 'RegularShift5');\nINSERT INTO StandardSchedule VALUES ('2008.01.07', 'RegularShift6');\nINSERT INTO StandardSchedule VALUES ('2008.01.09', 'RegularShift7');\nINSERT INTO StandardSchedule VALUES ('2008.01.10', 'RegularShift8');