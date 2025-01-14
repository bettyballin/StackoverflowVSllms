CREATE OR REPLACE TRIGGER enc_bob \nBEFORE INSERT ON BOB\nFOR EACH ROW\nDECLARE\n    v_name VARCHAR2(50);\nBEGIN\n    -- Decode base64 encoded RAW data to varchar2\n    v_name := UTL_RAW.CAST_TO_VARCHAR2(UTL_ENCODE.BASE64_DECODE(:NEW.name_enc));\n\n    -- encryption code that expects v_name to contain string \n    -- (assuming you have a procedure or function named encrypt_string)\n    :NEW.name_enc := your_encryption_function(v_name);\nEND;\n/