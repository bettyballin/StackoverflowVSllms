CREATE OR REPLACE PROCEDURE test_valid_date (p_date IN VARCHAR2) IS\n    v_date DATE;\nBEGIN\n    BEGIN\n        v_date := TO_DATE(p_date, 'DD-MON-YYYY'); -- Adjust format as needed\n        DBMS_OUTPUT.PUT_LINE('Valid date: ' || TO_CHAR(v_date, 'DD-MON-YYYY'));\n    EXCEPTION\n        WHEN OTHERS THEN\n            DBMS_OUTPUT.PUT_LINE('Invalid date: ' || p_date);\n    END;\nEND;\n/\n\n-- Example usage:\nBEGIN\n    test_valid_date('30-JAN-2009'); -- Valid date\n    test_valid_date('01-30-2009'); -- Invalid date\n    test_valid_date(''); -- Invalid date (treated as NULL)\nEND;\n/