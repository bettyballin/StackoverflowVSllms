CREATE OR REPLACE FUNCTION pivot_contact_attributes()\nRETURNS TABLE (\n  #profile INTEGER,\n  email VARCHAR,\n  name VARCHAR,\n  website VARCHAR,\n  -- add more columns as needed\n) AS $$\nBEGIN\n  RETURN QUERY\n  SELECT\n    #profile,\n    MAX(CASE WHEN type = 'email' THEN value END) AS email,\n    MAX(CASE WHEN type = 'name' THEN value END) AS name,\n    MAX(CASE WHEN type = 'website' THEN value END) AS website,\n    -- add more columns as needed\n  FROM contact_attributes\n  GROUP BY #profile;\nEND; $$ LANGUAGE plpgsql;