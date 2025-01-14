CREATE OR REPLACE FUNCTION check_resource_overscheduling()\nRETURNS TRIGGER AS $$\nDECLARE\n    conflict_exists BOOLEAN;\nBEGIN\n    SELECT TRUE INTO conflict_exists\n    FROM timespan t1, timespan t2, event_resource er1, event_resource er2\n    WHERE t1.resource_id = NEW.resource_id AND t2.resource_id = NEW.resource_id\n      AND t1.id <> t2.id\n      AND er1.event_id = t1.event_id AND er2.event_id = t2.event_id\n      AND er1.resource_id = t1.resource_id AND er2.resource_id = t2.resource_id\n      AND t1.day = t2.day\n      AND NOT (t1.end_time <= t2.start_time OR t1.start_time >= t2.end_time);\n\n    IF conflict_exists THEN\n        RAISE EXCEPTION 'Timespan conflicts with an existing timespan for the same resource.';\n    END IF;\n\n    RETURN NEW;\nEND;\n$$ LANGUAGE plpgsql;\n\nCREATE TRIGGER resource_overscheduling_trigger\nBEFORE INSERT OR UPDATE ON timespan\nFOR EACH ROW EXECUTE FUNCTION check_resource_overscheduling();