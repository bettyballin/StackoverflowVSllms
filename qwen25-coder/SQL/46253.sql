CREATE FUNCTION has_non_null_values RETURN BOOLEAN IS\nBEGIN\n    IF (p_c_courtesies_cd IS NOT NULL \n        OR p_c_language_cd IS NOT NULL\n        OR v_c_name IS NOT NULL\n        OR v_c_firstname IS NOT NULL\n        OR v_c_function IS NOT NULL\n        OR p_c_phone IS NOT NULL\n        OR p_c_mobile IS NOT NULL\n        OR p_c_fax IS NOT NULL\n        OR v_c_email IS NOT NULL) THEN\n        RETURN TRUE;\n    ELSE\n        RETURN FALSE;\n    END IF;\nEND has_non_null_values;