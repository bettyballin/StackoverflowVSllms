CREATE TABLE PRODUCT_ALIAS (\n  PRODUCT_NAME VARCHAR2(30),\n  ALIAS VARCHAR2(10)\n);\n\nINSERT INTO PRODUCT_ALIAS (PRODUCT_NAME, ALIAS)\nSELECT PRODUCT_NAME, SUBSTR(PRODUCT_NAME, 1, 10) FROM PRODUCT;\n\nSELECT \n  COMPANY_NAME,\n  ALIAS,\n  SALE_COUNT\nFROM (\n  SELECT \n    C.COMPANY_NAME,\n    PA.ALIAS,\n    PS.SALE_COUNT\n  FROM \n    COMPANY C\n    INNER JOIN PRODUCT_SALE PS ON C.ID_COMPANY = PS.ID_COMPANY\n    INNER JOIN PRODUCT P ON PS.ID_PRODUCT = P.ID_PRODUCT\n    INNER JOIN PRODUCT_ALIAS PA ON P.PRODUCT_NAME = PA.PRODUCT_NAME\n)\nPIVOT (\n  SUM(SALE_COUNT)\n  FOR ALIAS IN (SELECT DISTINCT ALIAS FROM PRODUCT_ALIAS)\n)