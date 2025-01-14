SELECT \n    Radio,\n    SUM(CASE WHEN Time < '12:00:00' THEN 1 ELSE 0 END) AS Window1,\n    SUM(CASE WHEN Time >= '13:00:00' AND Time < '15:00:00' THEN 1 ELSE 0 END) AS Window2,\n    SUM(CASE WHEN Time > '16:00:00' THEN 1 ELSE 0 END) AS Window3\nFROM \n    YourTableName\nGROUP BY \n    Radio;