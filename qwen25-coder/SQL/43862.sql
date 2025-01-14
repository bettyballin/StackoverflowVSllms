-- First, enable the row security feature on your table\nALTER TABLE employees ENABLE ROW LEVEL SECURITY;\n\n-- Then, create a policy that restricts access based on conditions\nCREATE POLICY employee_policy ON employees FOR SELECT USING (employee_id = current_setting('app.current_user', true)::int);\n\n-- An example function to set the current user's session variable\nCREATE OR REPLACE FUNCTION app.set_current_user(id INTEGER) RETURNS VOID AS $$\nBEGIN\n    EXECUTE format('SET LOCAL app.current_user TO %L', id);\nEND;\n$$ LANGUAGE plpgsql;