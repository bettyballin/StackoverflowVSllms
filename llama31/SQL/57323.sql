SELECT * FROM myTable WHERE \n  (field NOT LIKE '%$keyword[0]%' AND field NOT LIKE '%$keyword[1]%' AND ...)\n  OR (field LIKE '%$keyword[0]%' AND field NOT LIKE '%$keyword[1]%' AND ...)\n  ...