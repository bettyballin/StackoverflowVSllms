CREATE TABLE [dbo].[WeatherMeasurement](\n  MeasurementID [int] Identity(1,1) NOT NULL,\n  TownID [int] NOT NULL,\n  Temp [int] NOT NULL,\n  Date [datetime] NOT NULL,\n  IsCurrent [bit] NOT NULL\n);\n\n-- Index to speed up current temperature queries\nCREATE INDEX idx_CurrentRecords ON [dbo].[WeatherMeasurement] (IsCurrent) INCLUDE (TownID, Temp);