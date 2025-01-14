CREATE TABLE Class (\n    ClassID SERIAL PRIMARY KEY,\n    ClassName VARCHAR(255) NOT NULL,\n    ClassType ENUM('Coded', 'Numeric', 'String') NOT NULL,  -- Define the type of class\n    CHECK (ClassType IN ('Coded', 'Numeric', 'String'))\n);\n\nCREATE TABLE ClassCoded (\n    ClassID INT PRIMARY KEY,\n    Label VARCHAR(255) NOT NULL,\n    CodeValue INT NOT NULL,\n    FOREIGN KEY (ClassID) REFERENCES Class(ClassID),\n    UNIQUE (ClassID)\n);\n\nCREATE TABLE ClassNumeric (\n    ClassID INT PRIMARY KEY,\n    IntervalMin NUMERIC NOT NULL,\n    IntervalMax NUMERIC NOT NULL CHECK (IntervalMin < IntervalMax),\n    FOREIGN KEY (ClassID) REFERENCES Class(ClassID),\n    UNIQUE (ClassID)\n);\n\nCREATE TABLE ClassString (\n    ClassID INT PRIMARY KEY,\n    RegexPattern VARCHAR(255) NOT NULL,\n    FOREIGN KEY (ClassID) REFERENCES Class(ClassID),\n    UNIQUE (ClassID)\n);\n\n-- This trigger ensures that only one of the type-specific tables can have an entry for a given ClassID\nCREATE OR REPLACE FUNCTION check_class_type() RETURNS TRIGGER AS $$\nDECLARE\n    cnt INT;\nBEGIN\n    IF NEW.ClassType = 'Coded' THEN\n        SELECT COUNT(*) INTO cnt FROM ClassNumeric WHERE ClassID = NEW.ClassID;\n        IF cnt > 0 THEN RAISE EXCEPTION 'Class cannot be both Coded and Numeric'; END IF;\n\n        SELECT COUNT(*) INTO cnt FROM ClassString WHERE ClassID = NEW.ClassID;\n        IF cnt > 0 THEN RAISE EXCEPTION 'Class cannot be both Coded and String'; END IF;\n    ELSIF NEW.ClassType = 'Numeric' THEN\n        SELECT COUNT(*) INTO cnt FROM ClassCoded WHERE ClassID = NEW.ClassID;\n        IF cnt > 0 THEN RAISE EXCEPTION 'Class cannot be both Numeric and Coded'; END IF;\n\n        SELECT COUNT(*) INTO cnt FROM ClassString WHERE ClassID = NEW.ClassID;\n        IF cnt > 0 THEN RAISE EXCEPTION 'Class cannot be both Numeric and String'; END IF;\n    ELSIF NEW.ClassType = 'String' THEN\n        SELECT COUNT(*) INTO cnt FROM ClassCoded WHERE ClassID = NEW.ClassID;\n        IF cnt > 0 THEN RAISE EXCEPTION 'Class cannot be both String and Coded'; END IF;\n\n        SELECT COUNT(*) INTO cnt FROM ClassNumeric WHERE ClassID = NEW.ClassID;\n        IF cnt > 0 THEN RAISE EXCEPTION 'Class cannot be both String and Numeric'; END IF;\n    ELSE\n        RAISE EXCEPTION 'Invalid ClassType';\n    END IF;\n    RETURN NEW;\nEND;\n$$ LANGUAGE plpgsql;\n\nCREATE TRIGGER check_class_type_trigger\nBEFORE INSERT OR UPDATE ON Class\nFOR EACH ROW EXECUTE FUNCTION check_class_type();