SELECT [dbo].[AddBusinessHours]('2009-06-26 15:45:00', 9); -- returns '2009-06-29 15:45:00'\nSELECT [dbo].[AddBusinessHours]('2009-07-12 14:22:36', 18); -- returns '2009-07-13 08:30:00'\nSELECT [dbo].[AddBusinessHours]('2009-07-15 08:50:00', 4); -- returns '2009-07-15 12:50:00'