-- Example: Converting Hexadecimal '1A3F' to Decimal\nSELECT TO_NUMBER(TO_CHAR(HEXTORAW('1A3F'), 'FM999999999999')) AS decimal_value FROM dual;