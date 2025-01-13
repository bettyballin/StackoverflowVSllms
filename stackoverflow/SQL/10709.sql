select p1.branch, p1.patient\nfrom prescription p1, prescription p2\nwhere p1.patient=p2.patient\nand p1.dateoftest > p2.dateoftest\nand datediff('day', p2.dateoftest, p1.dateoftest) < 90;