SELECT \n  LOWER(\n    SUBSTR('Smith, John R', INSTR('Smith, John R', ',') + 2, 1) || \n    SUBSTR('Smith, John R', 1, INSTR('Smith, John R', ',') - 1)\n  ) AS result\nFROM DUAL;