SELECT \n    nr.nid, \n    nr.timestamp, \n    nr.title, \n    ua.dst\nFROM \n    (SELECT nid, MAX(timestamp) as timestamp, title \n     FROM node_revisions \n     GROUP BY nid \n     ORDER BY timestamp DESC \n     LIMIT 0, 5) AS nr\nJOIN \n    url_alias AS ua \nON \n    nr.nid = CAST(SUBSTRING(ua.src FROM 6) AS UNSIGNED)\nWHERE \n    ua.dst NOT LIKE '%feed';