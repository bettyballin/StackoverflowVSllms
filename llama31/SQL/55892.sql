SELECT \n  CONCAT(\n    '/',\n    32 - FLOOR(LOG2(4294967295 - ip_mask + 1))\n  ) AS cidr\nFROM subnets;