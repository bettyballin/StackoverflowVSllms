SELECT \n    DAYOFWEEK(eventDate) AS DAY, \n    YEAR(eventDate) AS YEAR, \n    GROUP_CONCAT(username SEPARATOR ', ') AS usernames,\n    `primary`, \n    secondary, \n    weekend\nFROM \n    eventcal\nWHERE \n    region = 4\n    AND MONTH(eventDate) = 7\nGROUP BY \n    DAYOFWEEK(eventDate), YEAR(eventDate), `primary`, secondary, weekend\nORDER BY \n    DAYOFWEEK(eventDate)