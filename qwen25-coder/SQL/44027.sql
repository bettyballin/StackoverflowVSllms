CREATE OR REPLACE FUNCTION handle_insert_errors() RETURNS TRIGGER AS \$\$\nBEGIN\n    NEW.st_fips := NULLIF(NULLIF(NEW.st_fips, ''), CAST('' as integer));\n    NEW.sfips := NULLIF(NULLIF(NEW.sfips, ''), CAST('' as integer));\n    -- Add similar rows for other columns as necessary\n    RETURN NEW;\nEND;\n\$\$ LANGUAGE plpgsql;\n\nCREATE TRIGGER clean_inserts BEFORE INSERT ON target_table FOR EACH ROW EXECUTE FUNCTION handle_insert_errors();