SELECT DATE_FORMAT(m.`when`, '%e/%c/%Y') AS date,\n       COUNT(m.`ip`) AS AddressCount\n  FROM `metrics` m\n  JOIN `projects` p ON m.`projID` = p.`projID`\n WHERE p.`userID` = '1'\n GROUP BY DATE(m.`when`);