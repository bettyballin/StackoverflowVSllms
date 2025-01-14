CREATE OR REPLACE FUNCTION end_spool()\nRETURNS SETOF spool AS $$\nBEGIN\n    RETURN QUERY\n    SELECT *\n    FROM spool\n    WHERE key = g_spool_key\n    ORDER BY seq;\nEND;\n$$ LANGUAGE plpgsql;