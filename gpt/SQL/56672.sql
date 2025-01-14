CREATE OR REPLACE TRIGGER TRG_T1_TBL1_COL1\nFOR INSERT OR UPDATE OF t1_appnt_evnt_id ON TBL1\nCOMPOUND TRIGGER\n  TYPE t_appnt_evnt_id_list IS TABLE OF TBL1.t1_appnt_evnt_id%TYPE INDEX BY PLS_INTEGER;\n  v_appnt_evnt_id_list t_appnt_evnt_id_list;\n  v_reassign_count NUMBER(20);\n\n  BEFORE EACH ROW IS\n  BEGIN\n    IF :NEW.t1_prnt_t1_pk IS NOT NULL THEN\n      v_appnt_evnt_id_list(v_appnt_evnt_id_list.COUNT + 1) := :NEW.t1_appnt_evnt_id;\n    END IF;\n  END BEFORE EACH ROW;\n\n  AFTER STATEMENT IS\n  BEGIN\n    FOR i IN 1 .. v_appnt_evnt_id_list.COUNT LOOP\n      SELECT COUNT(t1_pk) INTO v_reassign_count\n      FROM TBL1\n      WHERE t1_appnt_evnt_id = v_appnt_evnt_id_list(i) AND t1_prnt_t1_pk IS NOT NULL;\n      \n      IF v_reassign_count > 0 THEN\n        RAISE_APPLICATION_ERROR(-20013, 'Multiple reassignments not allowed');\n      END IF;\n    END LOOP;\n  END AFTER STATEMENT;\nEND TRG_T1_TBL1_COL1;