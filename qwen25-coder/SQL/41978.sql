SELECT \n    trn.WID_DATE, \n    trn.MINE_CODE, \n    trn.TRAIN_CONTROL_ID, \n    trn.NUM_CARS as HBD_Car_Count,\n    SUM(CASE WHEN vcon.WAGON_TYPE_CODE = 'MS' THEN 1 ELSE 0 END) AS M_Series,\n    (SUM(CASE WHEN vcon.WAGON_TYPE_CODE = 'SS' THEN 1 ELSE 0 END) - SUM(CASE WHEN wag.ACI_TAG_NO = 'HI0000' THEN 1 ELSE 0 END)) AS S_Series,\n    SUM(CASE WHEN vcon.WAGON_TYPE_CODE = 'CS' THEN 1 ELSE 0 END) AS C_Series, \n    SUM(CASE WHEN wag.ACI_TAG_NO = 'HI0000' THEN 1 ELSE 0 END) as No_Tag,\n    (COUNT(1) - trn.NUM_CARS) DB_Mismatch\nFROM widsys.consist con, widsys.train trn, widsys.wagon wag, widsys.v_consist_ore_detail vcon\nWHERE trn.TRAIN_RECORD_ID = con.TRAIN_RECORD_ID \nAND con.WAGON_ID = wag.WAGON_ID \nAND ((vcon.CONSIST_ID=con.CONSIST_ID) \nAND trn.MINE_CODE In (:mine) \nAND (trn.DIRECTION='N') \nAND (wag.ACI_TAG_TYPE In ('CONTROL','SLAVE','ORE')) \nAND (trn.WID_DATE>=TO_TIMESTAMP(:startDate, 'YYYY-MM-DD HH24:MI:SS'))\nAND trn.WID_DATE<=TO_TIMESTAMP(:endDate, 'YYYY-MM-DD HH24:MI:SS')))\nGROUP BY trn.WID_DATE, trn.MINE_CODE, trn.TRAIN_CONTROL_ID, trn.NUM_CARS\nORDER BY trn.WID_DATE DESC;