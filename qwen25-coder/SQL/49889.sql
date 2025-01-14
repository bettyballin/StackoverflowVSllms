BEGIN\n  EXECUTE IMMEDIATE 'CREATE TABLE A (PKey NUMBER NOT NULL GENERATED BY DEFAULT AS IDENTITY, NewFieldKey NUMBER NULL, CONSTRAINT PK_A PRIMARY KEY (PKey))';\n  \n  BEGIN\n    EXECUTE IMMEDIATE 'CREATE INDEX A_2 ON A (NewFieldKey)';\n  EXCEPTION \n    WHEN OTHERS THEN\n      ROLLBACK;\n      RAISE;\n  END;\n\n  BEGIN\n    EXECUTE IMMEDIATE 'CREATE TABLE B (PKey NUMBER NOT NULL GENERATED BY DEFAULT AS IDENTITY, CONSTRAINT PK_B PRIMARY KEY (PKey))';\n  EXCEPTION \n    WHEN OTHERS THEN\n      ROLLBACK;\n      RAISE;\n  END;\n\n  BEGIN\n    EXECUTE IMMEDIATE 'ALTER TABLE A ADD CONSTRAINT FK_B_A FOREIGN KEY (NewFieldKey) REFERENCES B (PKey)';\n  EXCEPTION \n    WHEN OTHERS THEN\n      ROLLBACK;\n      RAISE;\n  END;\n  \nEXCEPTION\n  WHEN OTHERS THEN\n    ROLLBACK;\n    RAISE;\nEND;\n/