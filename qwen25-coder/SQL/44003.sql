SELECT DATE(TIMESTAMPADD(DAY,\n                         - (DAY(CURRENT DATE) - 1),\n                         CURRENT DATE))\nFROM SYSIBM.SYSDUMMY1;