SELECT \n    i.`id`, \n    i.`title`, \n    g.`id` as 'groupId', \n    g.`groupTitle`, \n    g.`externalURL`\nFROM \n    items i \n    LEFT JOIN groups g ON (i.`groupId` = g.`id`)\n\nUNION ALL\n\nSELECT \n    NULL, \n    NULL, \n    g.`id`, \n    g.`groupTitle`, \n    g.`externalURL`\nFROM \n    groups g \nWHERE \n    g.`externalURL` IS NOT NULL AND g.`id` NOT IN (SELECT `groupId` FROM items)