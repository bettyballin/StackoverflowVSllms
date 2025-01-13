SELECT *\nFROM member\nWHERE \n    DATE_FORMAT(DOB, '%m-%d') BETWEEN DATE_FORMAT(CURDATE() - INTERVAL 14 DAY, '%m-%d') AND DATE_FORMAT(CURDATE(), '%m-%d')\nOR \n    (DATE_FORMAT(CURDATE() - INTERVAL 14 DAY, '%m-%d') > DATE_FORMAT(CURDATE(), '%m-%d')\n    AND \n    (DATE_FORMAT(DOB, '%m-%d') BETWEEN '01-01' AND DATE_FORMAT(CURDATE(), '%m-%d') \n    OR \n    DATE_FORMAT(DOB, '%m-%d') BETWEEN DATE_FORMAT(CURDATE() - INTERVAL 14 DAY, '%m-%d') AND '12-31'));