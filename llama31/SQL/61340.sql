CREATE OR REPLACE TRIGGER enc_bob\nBEFORE INSERT ON BOB\nFOR EACH ROW\nDECLARE\n    v_name VARCHAR2(50);\nBEGIN\n    v_name := UTL_RAW.CAST_TO_VARCHAR2(HEXTORAW(:new.name_enc));\n    -- encryption code that expects v_name to contain string\nEND;