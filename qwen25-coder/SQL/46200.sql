SELECT \n    IPAddress.Status as status,\n    IPAddress.Address as ip,\n    IPAddress.PCName as pc_name,\n    MAX(CASE WHEN Numbers.Phone = 'CPU/' + IPAddress.PCName THEN 1 ELSE 0 END) AS cpu_contact,\n    MAX(CASE WHEN Numbers.Phone = 'PC/' + IPAddress.PCName THEN 1 ELSE 0 END) AS pc_contact,\n    MAX(CASE WHEN Numbers.Phone = 'LOGIN/' + IPAddress.PCName THEN 1 ELSE 0 END) AS login_contact\nFROM \n    IPAddress\nLEFT JOIN \n    Numbers\nON \n    Numbers.Phone IN (\n        'CPU/' + IPAddress.PCName, \n        'PC/' + IPAddress.PCName, \n        'LOGIN/' + IPAddress.PCName\n    )\nWHERE \n    $where  -- Generated In code\nGROUP BY \n    IPAddress.Status,\n    IPAddress.Address,\n    IPAddress.PCName;