while ($row = db2_fetch_assoc($result)) {\n    $FC->addChartData($row['SALES'], "label=$row['ITEM']");\n}