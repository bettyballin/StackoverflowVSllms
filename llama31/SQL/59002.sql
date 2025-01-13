-- Create a materialized view\nCREATE VIEW [dbo].[VehicleData]\nWITH SCHEMABINDING\nAS\nSELECT v.*, r.RadioName, c.CupholderName, t.TyreType\nFROM [dbo].[Vehicles] v\nINNER JOIN [dbo].[Radios] r ON v.RadioID = r.RadioID\nINNER JOIN [dbo].[Cupholders] c ON v.CupholderID = c.CupholderID\nINNER JOIN [dbo].[TyreTypes] t ON v.TyreTypeID = t.TyreTypeID;\n\n-- Create an index on the materialized view\nCREATE UNIQUE CLUSTERED INDEX [IDX_VehicleData] ON [dbo].[VehicleData] ([VehicleID]);