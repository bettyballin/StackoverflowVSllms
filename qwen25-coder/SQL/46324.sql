DECLARE\n     v_next_id NUMBER;\n   BEGIN\n     FOR r IN (SELECT ROWNUM rnum FROM my_table) LOOP\n       SELECT my_table_seq.NEXTVAL INTO v_next_id FROM dual;\n       UPDATE my_table \n       SET id = v_next_id \n       WHERE ROWNUM <= r.rnum AND id IS NULL;\n     END LOOP;\n   END;