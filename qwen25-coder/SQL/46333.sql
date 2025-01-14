SELECT \n    SUM(CASE WHEN TBL_REPAIR_ORDER.STATUS <> 'Completed' THEN 1 ELSE 0 END) AS IncompleteOrders,\n    COUNT(TBL_PROPERTY.PROPREF) AS TotalOrders\nFROM    \n    TBL_PROPERTY \nINNER JOIN \n    TBL_REPAIR_ORDER ON TBL_PROPERTY.PROPREF = TBL_REPAIR_ORDER.PROPREF \nINNER JOIN \n    TBL_REPAIR_VISIT ON TBL_REPAIR_ORDER.ORDERID = TBL_REPAIR_VISIT.ORDERID \nINNER JOIN\n    tbl_contract ON tbl_repair_order.CONTRACT = tbl_contract.CONTRACT\nWHERE   \n    (TBL_CONTRACT.CONTRACT IN ('STE')) AND\n    (TBL_REPAIR_ORDER.RAISEDDATE BETWEEN '01/12/2008' AND DATEADD(hh, 23, '01/01/2009'))