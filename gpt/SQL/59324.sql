CREATE OR REPLACE FUNCTION handle_retrieval(your_column IN VARCHAR2)\nRETURN VARCHAR2\nIS\nBEGIN\n    IF your_column = '@' THEN\n        RETURN '';\n    ELSE\n        RETURN your_column;\n    END IF;\nEND;\n/