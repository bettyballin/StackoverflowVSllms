SELECT a.readings_miu_id, a.Reading, a.ReadDate, a.ReadTime, \n       a.MIUwindow, a.SN, a.Noise, a.RSSI, a.OriginCol, a.ColID, a.Ownage\nFROM analyzed a\nWHERE a.ReadDate Between #4/21/2009# and #4/29/2009#  \nAND a.ReadTime = (\n    SELECT MAX(a2.ReadTime)\n    FROM analyzed a2\n    WHERE a2.readings_miu_id = a.readings_miu_id \n    AND a2.ReadDate = a.ReadDate\n);