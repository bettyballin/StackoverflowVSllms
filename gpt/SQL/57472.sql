-- Function to notify the server\nCREATE OR REPLACE FUNCTION notify_update()\nRETURNS trigger AS $$\nBEGIN\n  PERFORM pg_notify('data_update', row_to_json(NEW)::text);\n  RETURN NEW;\nEND;\n$$ LANGUAGE plpgsql;\n\n-- Trigger to call the notify function\nCREATE TRIGGER data_update_trigger\nAFTER INSERT OR UPDATE ON your_table\nFOR EACH ROW EXECUTE FUNCTION notify_update();