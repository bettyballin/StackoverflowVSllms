-- Application: SalesApp, Module: OrderProcessing, Function: CreateOrder\nBEGIN\n  DBMS_SESSION.SET_CONTEXT('USERENV', 'CLIENT_INFO', 'SalesApp|OrderProcessing|CreateOrder');\nEND;\n\nSELECT * FROM orders WHERE order_id = 1234;