SELECT readings_miu_id, ReadDate, ReadTime, RSSI, Firmware, Active, OriginCol, ColID, Ownage, SiteID, PremID, prem_group1, prem_group2  \nINTO analyzedCopy2  \nFROM analyzedCopy AS A \nWHERE (A.Readings_Miu_ID, A.ReadDate) IN (\n    SELECT AC.readings_miu_id, AC.ReadDate\n    FROM analyzedCopy AS AC\n    INNER JOIN (\n        SELECT readings_miu_id, ReadDate, MIN(ReadTime) AS MinReadTime\n        FROM analyzedCopy\n        GROUP BY readings_miu_id, ReadDate\n    ) AS B ON AC.readings_miu_id = B.readings_miu_id AND AC.ReadDate = B.ReadDate AND AC.ReadTime = B.MinReadTime\n)\nORDER BY A.readings_miu_id, A.ReadDate;