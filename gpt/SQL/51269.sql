-- Check for triggers on crazytable\n    SELECT trigger_name FROM all_triggers WHERE table_name = 'CRAZYTABLE';\n\n    -- Check for constraints on crazytable\n    SELECT constraint_name, constraint_type FROM all_constraints WHERE table_name = 'CRAZYTABLE';