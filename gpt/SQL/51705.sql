CREATE OR REPLACE TYPE BODY message_type AS\n    -- No need to override enqueue if the base implementation is sufficient\nEND;\n/