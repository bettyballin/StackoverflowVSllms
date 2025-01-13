UPDATE SHIPMENT\nSET \n    OrgAddress1 = bd.OrgAddress,\n    OrgAddress2 = bd.OrgAddress2,\n    OrgCity = bd.OrgCity,\n    OrgState = bd.OrgState,\n    OrgZip = bd.OrgZip,\n    DestAddress1 = bd.DestAddress,\n    DestAddress2 = bd.DestAddress2,\n    DestCity = bd.DestCity,\n    DestState = bd.DestState,\n    DestZip = bd.DestZip\nFROM \n    SHIPMENT s\nINNER JOIN \n    ProfilerTest.dbo.BookingDetails bd\nON \n    s.MyID2 = bd.MyID\nWHERE \n    bd.MyID = @MyID