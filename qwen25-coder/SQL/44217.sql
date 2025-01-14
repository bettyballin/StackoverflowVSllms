DECLARE\n    l_blob BLOB;\n    l_length NUMBER;\n    l_index NUMBER := 1;\n    l_value FLOAT;\n    l_max FLOAT := -1/0; -- Smallest possible float (approximation for infinity)\n    l_min FLOAT := 1/0;  -- Largest possible float (approximation for infinity)\n    l_sum FLOAT := 0.0;\n    l_count NUMBER := 0;\nBEGIN\n    SELECT waveform_blob INTO l_blob FROM waveforms WHERE id = 1;\n    l_length := DBMS_LOB.GETLENGTH(l_blob);\n\n    WHILE l_index <= l_length LOOP\n        l_value := UTL_RAW.CAST_TO_BINARY_DOUBLE(DBMS_LOB.SUBSTR(l_blob, 8, l_index));\n        IF l_value > l_max THEN l_max := l_value; END IF;\n        IF l_value < l_min THEN l_min := l_value; END IF;\n        l_sum := l_sum + l_value;\n        l_count := l_count + 1;\n        l_index := l_index + 8;\n    END LOOP;\n\n    DBMS_OUTPUT.PUT_LINE('Max: ' || l_max);\n    DBMS_OUTPUT.PUT_LINE('Min: ' || l_min);\n    DBMS_OUTPUT.PUT_LINE('Average: ' || (l_sum / l_count));\nEND;\n/