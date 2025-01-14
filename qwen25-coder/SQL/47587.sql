DECLARE\n    v_number NUMBER := 12345.67;\n    v_formatted VARCHAR2(50);\nBEGIN\n    -- Format the number with commas and round to two decimal places\n    v_formatted := TO_CHAR(v_number, 'FM999G999D99', 'NLS_NUMERIC_CHARACTERS=,.');\n\n    -- Insert space before the last three digits if necessary\n    IF LENGTH(v_formatted) > 4 THEN\n        v_formatted := SUBSTR(v_formatted, 1, LENGTH(v_formatted) - 3) || ' ' || SUBSTR(v_formatted, LENGTH(v_formatted) - 2);\n    END IF;\n\n    DBMS_OUTPUT.PUT_LINE(v_formatted);\nEND;