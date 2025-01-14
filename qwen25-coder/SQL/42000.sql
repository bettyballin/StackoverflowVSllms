WITH distinct_wagons AS (\n    SELECT DISTINCT wag.ACI_TAG_NO, vcon.WAGON_TYPE_CODE\n    FROM widsys.consist con\n    JOIN widsys.train trn ON trn.TRAIN_RECORD_ID = con.TRAIN_RECORD_ID \n    JOIN widsys.wagon wag ON con.WAGON_ID = wag.WAGON_ID \n    JOIN widsys.v_consist_ore_detail vcon ON vcon.CONSIST_ID = con.CONSIST_ID\n    WHERE trn.MINE_CODE In (:mine) \n      AND trn.DIRECTION='N' \n      AND wag.ACI_TAG_TYPE In ('CONTROL','SLAVE','ORE') \n      AND (trn.WID_DATE>=TO_TIMESTAMP(:startDate, 'YYYY-MM-DD HH24:MI:SS'))\n      AND trn.WID_DATE<=TO_TIMESTAMP(:endDate, 'YYYY-MM-DD HH24:MI:SS')\n)\nSELECT \n    trn.WID_DATE, \n    trn.MINE_CODE, \n    trn.TRAIN_CONTROL_ID, \n    trn.NUM_CARS as HBD_Car_Count,\n    SUM(CASE WHEN dw.WAGON_TYPE_CODE = 'MS' THEN 1 ELSE 0 END) AS M_Series,\n    (SUM(CASE WHEN vcon.WAGON_TYPE_CODE = 'SS' THEN 1 ELSE 0 END) - SUM(CASE WHEN wag.ACI_TAG_NO = 'HI0000' THEN 1 ELSE 0 END)) AS S_Series,\n    SUM(CASE WHEN vcon.WAGON_TYPE_CODE = 'CS' THEN 1 ELSE 0 END) AS C_Series, \n    SUM(CASE WHEN wag.ACI_TAG_NO = 'HI0000' THEN 1 ELSE 0 END) as No_Tag,\n    (COUNT(1) - trn.NUM_CARS) DB_Mismatch\nFROM widsys.consist con\nJOIN widsys.train trn ON trn.TRAIN_RECORD_ID = con.TRAIN_RECORD_ID \nJOIN widsys.wagon wag ON con.WAGON_ID = wag.WAGON_ID \nJOIN widsys.v_consist_ore_detail vcon ON vcon.CONSIST_ID = con.CONSIST_ID\nLEFT JOIN distinct_wagons dw ON dw.ACI_TAG_NO = wag.ACI_TAG_NO AND dw.WAGON_TYPE_CODE = vcon.WAGON_TYPE_CODE\nWHERE trn.MINE_CODE In (:mine) \n  AND trn.DIRECTION='N' \n  AND (trn.WID_DATE>=TO_TIMESTAMP(:startDate, 'YYYY-MM-DD HH24:MI:SS'))\n  AND trn.WID_DATE<=TO_TIMESTAMP(:endDate, 'YYYY-MM-DD HH24:MI:SS')\nGROUP BY trn.WID_DATE, trn.MINE_CODE, trn.TRAIN_CONTROL_ID, trn.NUM_CARS\nORDER BY trn.WID_DATE DESC;