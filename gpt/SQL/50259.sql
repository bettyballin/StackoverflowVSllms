CREATE OR REPLACE PACKAGE BODY my_package AS\n\n       FUNCTION my_function RETURN VARCHAR2 AS\n       BEGIN\n           IF (SELECT feature_flag FROM config_table WHERE feature_name = 'new_feature') = 'ENABLED' THEN\n               -- New feature code\n               RETURN 'New feature is active';\n           ELSE\n               -- Existing functionality\n               RETURN 'Old feature is active';\n           END IF;\n       END my_function;\n\n   END my_package;