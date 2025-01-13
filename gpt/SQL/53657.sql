CREATE TABLE Entity (\n  id SERIAL PRIMARY KEY,\n  name VARCHAR(100),\n  dynamic_fields JSONB\n);\n\n-- Insert example\nINSERT INTO Entity (name, dynamic_fields)\nVALUES ('Example', '{"customField1": "customValue1", "customField2": "customValue2"}');\n\n-- Query example\nSELECT * FROM Entity WHERE dynamic_fields->>'customField1' = 'customValue1';