select \n    src.TrnNumber,\n    srcSt.StnName as SourceStation, \n    srcSt.StnCity as SourceCity,\n    src.DepTime,\n    destSt.StnName as DestinationStation,\n    destSt.StnCity as DestinationCity,\n    dest.ArrTime,\n    (abs(dest.HopIndex - src.HopIndex)) as Stops\nfrom\n    TrainHopTbl src\n    inner join TrainHopTbl dest on\n        src.TrnNumber = dest.TrnNumber\n    inner join StationTbl srcSt on\n        src.StnCode = srcSt.StationCode\n    inner join StationTbl destSt on\n        dest.StnCode = destSt.StationCode\nwhere\n    src.StnCode = 'WDC'\n    and dest.StnCode = 'NYC'\n    and src.HopIndex < dest.HopIndex\norder by\n    Stops asc,\n    DepTime asc