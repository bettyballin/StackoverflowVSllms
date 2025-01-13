DECLARE\n    v_task_name VARCHAR2(50) := 'my_task';\n    v_sql       VARCHAR2(4000) := 'BEGIN your_procedure_name; END;';\n    v_timeout   NUMBER := 300; -- 5 minutes\nBEGIN\n    -- Create a task\n    DBMS_PARALLEL_EXECUTE.CREATE_TASK (task_name => v_task_name);\n\n    -- Create a chunk\n    DBMS_PARALLEL_EXECUTE.CREATE_CHUNKS_BY_SQL (\n        task_name => v_task_name,\n        sql_stmt  => v_sql,\n        chunk_size => 1\n    );\n\n    -- Execute the task\n    DBMS_PARALLEL_EXECUTE.RUN_TASK (\n        task_name      => v_task_name,\n        synchronous    => FALSE\n    );\n\n    -- Wait for the task to complete or timeout\n    FOR i IN 1..v_timeout LOOP\n        DBMS_LOCK.SLEEP(1); -- Sleep for 1 second\n        IF DBMS_PARALLEL_EXECUTE.TASK_STATUS(v_task_name) = DBMS_PARALLEL_EXECUTE.FINISHED THEN\n            EXIT;\n        END IF;\n    END LOOP;\n\n    -- Check status and handle timeout\n    IF DBMS_PARALLEL_EXECUTE.TASK_STATUS(v_task_name) != DBMS_PARALLEL_EXECUTE.FINISHED THEN\n        -- Handle timeout, e.g., kill the task or raise an exception\n        DBMS_OUTPUT.PUT_LINE('Task timed out.');\n    ELSE\n        DBMS_OUTPUT.PUT_LINE('Task completed.');\n    END IF;\n\n    -- Don't forget to drop the task to clean up\n    DBMS_PARALLEL_EXECUTE.DROP_TASK(v_task_name);\nEND;