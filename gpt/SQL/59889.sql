CREATE OR REPLACE PROCEDURE GETSOMEDATA\n(\n    P_Data OUT SYS_REFCURSOR\n)\nAS\nBEGIN\n    OPEN P_Data FOR SELECT * FROM SOMETABLE;\nEND GETSOMEDATA;