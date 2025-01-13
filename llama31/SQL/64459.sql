CREATE OR REPLACE FUNCTION concat_distinct(acc text, instr text)\nRETURNS text AS $$\nBEGIN\n    IF acc IS NULL OR acc = '' THEN\n      RETURN instr;\n    ELSE\n      IF instr = ANY(string_to_array(acc, ';')) THEN\n        RETURN acc;\n      ELSE\n        RETURN acc || ';' || instr;\n      END IF;\n    END IF;\nEND;\n$$ LANGUAGE plpgsql;