CREATE OR REPLACE PROCEDURE test_refcur IS\n   refCursorValue SYS_REFCURSOR;\n   allValues VARCHAR2(4000);\n   idArray SYS.ODCIVARCHAR2LIST := SYS.ODCIVARCHAR2LIST('12345', '67890');  -- Example IDs\n   resultRecord dashboard%ROWTYPE;\nBEGIN\n   -- Create a new ref cursor for the combined results\n   OPEN refCursorValue FOR \n      SELECT cat, cat_order, subcat, label_text,\n             MAX(CASE WHEN id_number = '12345' THEN current_month END) AS cm_12345,\n             MAX(CASE WHEN id_number = '67890' THEN current_month END) AS cm_67890\n      FROM (\n         SELECT cat, cat_order, subcat, label_text, id_number,\n                TRIM(TO_CHAR(SUM(current_month), '9,999,999,999')) current_month\n           FROM dashboard\n          WHERE id_number IN (SELECT * FROM TABLE(idArray))\n          GROUP BY cat_order, subcat, cat, label_text, id_number\n      ) a\n   GROUP BY cat, cat_order, subcat, label_text\n   ORDER BY cat_order, subcat;\n\n   -- Fetch and print results from the new ref cursor\n   LOOP\n      FETCH refCursorValue INTO resultRecord;\n      EXIT WHEN refCursorValue%NOTFOUND;\n      \n      dbms_output.put_line('Cat: ' || resultRecord.cat || ', CatOrder: ' || resultRecord.cat_order || \n                           ', Subcat: ' || resultRecord.subcat || ', LabelText: ' || resultRecord.label_text ||\n                           ', CM_12345: ' || resultRecord.current_month || ', CM_67890: ');  -- Adjust if needed\n   END LOOP;\n   \n   CLOSE refCursorValue;\nEND test_refcur;