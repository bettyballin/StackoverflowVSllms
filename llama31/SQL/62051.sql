BEGIN TRANSACTION;\nDELETE FROM mytable WHERE column = 'value';\nSELECT * FROM mytable;  -- preview the results\nROLLBACK TRANSACTION;