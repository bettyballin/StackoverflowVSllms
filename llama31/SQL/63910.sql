-- Create a new web service\nBEGIN\n  DBMS_XDB.createWebService(\n    serviceName => 'myService',\n    serviceUri  => '/myService',\n    schema      => 'MY_SCHEMA',\n    procedure   => 'myProcedure'\n  );\nEND;\n\n-- Define the stored procedure\nCREATE OR REPLACE PROCEDURE myProcedure\n  (p_input  IN  VARCHAR2,\n   p_output OUT VARCHAR2)\nAS\nBEGIN\n  p_output := 'Hello, ' || p_input;\nEND;