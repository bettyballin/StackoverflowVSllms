SELECT DATE_FORMAT(`when`, '%e_%c_%Y')date, COUNT(distinct `ip`) AddressCount FROM `Metrics` WHERE `ID` = '1' GROUP BY date