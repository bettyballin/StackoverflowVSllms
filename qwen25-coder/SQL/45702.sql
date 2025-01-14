CREATE OR REPLACE PROCEDURE ValidateParameters(\n    p_dateStart IN DATE,\n    p_dateEnd   IN DATE,\n    p_fooParm   IN VARCHAR2,\n    p_codeStart IN NUMBER,\n    p_codeEnd   IN NUMBER\n) AS\n    v_diff NUMBER;\nBEGIN\n    -- Check date range is not more than a year\n    SELECT MONTHS_BETWEEN(p_dateEnd, p_dateStart)\n    INTO v_diff\n    FROM DUAL;\n\n    IF v_diff > 12 THEN\n        RAISE_APPLICATION_ERROR(-20002, 'Date range must be less than one year.');\n    END IF;\n\n    -- Check either FooParm or Codes condition\n    IF p_fooParm IS NULL OR p_fooParm = '' THEN\n        IF p_codeStart IS NULL OR p_codeEnd IS NULL THEN\n            RAISE_APPLICATION_ERROR(-20003, 'Either FooParm must be supplied or both CodeStart and CodeEnd.');\n        ELSIF p_codeStart >= p_codeEnd OR (p_codeEnd - p_codeStart + 1) > 1000 THEN\n            RAISE_APPLICATION_ERROR(-20004, 'Difference between CodeStart and CodeEnd must be less than 1001.');\n        END IF;\n    END IF;\n\n    -- If all checks pass, return a success message (if needed)\n    -- INSERT INTO ErrorLogTable (message) VALUES ('Validation successful.');\n\nEND ValidateParameters;\n/