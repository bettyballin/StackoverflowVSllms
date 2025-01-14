PROCEDURE yearly_summary_proc (p_last_id IN NUMBER DEFAULT 0) IS\n        CURSOR c_data IS\n            SELECT id, other_column\n            FROM your_table\n            WHERE id > p_last_id\n            ORDER BY id\n            FETCH FIRST 100 ROWS ONLY;\n\n        v_last_id your_table.id%TYPE;\n    BEGIN\n        FOR rec IN c_data LOOP\n            -- Perform lengthy calculation here\n            NULL; -- Replace with real update logic\n\n            v_last_id := rec.id;\n        END LOOP;\n\n        -- Schedule the next run only if there are more rows to process\n        IF SQL%FOUND AND v_last_id IS NOT NULL THEN\n            DBMS_SCHEDULER.create_job (\n                job_name   => 'yearly_summary',\n                job_type   => 'STORED_PROCEDURE',\n                job_action => 'your_schema.yearly_summary_proc(:last_id)',\n                start_date => SYSTIMESTAMP + INTERVAL '1' MINUTE,\n                enabled    => TRUE\n            );\n            DBMS_SCHEDULER.set_job_argument_value('yearly_summary', 1, v_last_id);\n        END IF;\n    EXCEPTION\n        WHEN OTHERS THEN\n            -- Handle any exceptions that occur during the procedure execution\n            NULL; -- Replace with real exception handling\n    END yearly_summary_proc;