BEGIN TRANSACTION;\n\nUPDATE ods\nSET oildatasetstatusid = CASE \n                             WHEN ods.oildatasetstatusid = 5 THEN 16 \n                             WHEN ods.oildatasetstatusid = 6 THEN 17 \n                             WHEN ods.oildatasetstatusid = 7 THEN 18 \n                             WHEN ods.oildatasetstatusid = 8 THEN 18 \n                             WHEN ods.oildatasetstatusid = 9 THEN 18 \n                             WHEN ods.oildatasetstatusid = 10 THEN 19 \n                             WHEN ods.oildatasetstatusid = 11 THEN 20 \n                         END\nFROM oildatasetstatus ods\nINNER JOIN oildataset od ON od.oildatasetid = ods.oildatasetid\nINNER JOIN samplepoint sp ON sp.samplepointid = od.samplepointid\nINNER JOIN customersite cs ON cs.customersiteid = sp.customersiteid\nWHERE cs.customerid = 2;\n\nUPDATE od\nSET oillabid = 9\nFROM oildataset od\nINNER JOIN oildatasetstatus ods ON ods.oildatasetid = od.oildatasetid\nWHERE ods.oildatasetstatusid BETWEEN 16 AND 20;\n\nCOMMIT;