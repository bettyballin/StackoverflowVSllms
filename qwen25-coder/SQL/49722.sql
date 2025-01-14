SELECT\n    i.`id`,\n    i.`title`,\n    g.`id` as 'groupId',\n    g.`groupTitle`,\n    g.`externalURL`\nFROM\n    groups g\nLEFT JOIN\n    items i ON (g.`id` = i.`groupId`)\nWHERE\n    g.`externalURL` IS NULL OR i.`id` IS NOT NULL;