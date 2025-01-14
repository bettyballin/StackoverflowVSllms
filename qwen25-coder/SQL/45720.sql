SELECT DATE_FORMAT(m.`when`, '%e/%c/%Y') AS date,\n       COUNT(m.`ip`) AS AddressCount\nFROM `metrics` m\nJOIN `projects` p ON m.`projID` = p.`projID`\nWHERE p.`userID` = '1'\nGROUP BY DATE(m.`when`);