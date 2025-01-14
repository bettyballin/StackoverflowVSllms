CREATE OR REPLACE TRIGGER MYTRIGGER\nAFTER INSERT ON SOMETABLE\nFOR EACH ROW\n\nDECLARE\n    v_emplid varchar2(10);\n\nBEGIN\n    SELECT personnum\n    INTO v_emplid\n    FROM PERSON\n    WHERE PERSONID = :new.EMPLOYEEID;\n\n    dbms_output.put_line(v_emplid);\n\n    /* INSERT INTO SOMEOTHERTABLE USING v_emplid and some of the other values from the trigger table */\n\nEND MYTRIGGER;\n/