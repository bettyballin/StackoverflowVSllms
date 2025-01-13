SELECT sysdate,\n  (\n  CASE\n    WHEN TRUNC(sysdate) IN\n      (SELECT h.holidaydate FROM holiday h)\n    THEN 'holiday'  \n    ELSE TO_CHAR(sysdate, 'day')\n  END)\nFROM dual;