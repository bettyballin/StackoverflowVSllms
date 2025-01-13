CREATE TABLE SCHEMA_NAME.PRODUCT (\n    PRODUCT_ID RAW(16) DEFAULT SYS_GUID() NOT NULL,\n    PRODUCT_CODE VARCHAR2(10 CHAR) NOT NULL,\n    PRODUCT_NAME VARCHAR2(30 CHAR) NOT NULL,\n    PRODUCT_DESC VARCHAR2(512 CHAR)\n);