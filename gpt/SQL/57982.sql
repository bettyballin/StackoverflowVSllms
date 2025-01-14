CREATE OR REPLACE FUNCTION rm_category_update(\n    icompany bpchar,\n    iraw_mat_cat_code bpchar,\n    iraw_mat_cat_desc bpchar\n)\nRETURNS character AS\n$BODY$\nDECLARE\n    loc_result CHAR(50);\n    row_count INT;\nBEGIN\n    UPDATE rm_category\n    SET\n        raw_mat_cat_code = iraw_mat_cat_code,\n        raw_mat_cat_desc = iraw_mat_cat_desc\n    WHERE company = icompany;\n\n    GET DIAGNOSTICS row_count = ROW_COUNT;\n\n    IF row_count = 0 THEN\n        loc_result = 'no rows updated';\n    ELSE\n        loc_result = 'success';\n    END IF;\n\n    RETURN loc_result;\nEND;\n$BODY$\nLANGUAGE 'plpgsql' VOLATILE;\n\nALTER FUNCTION rm_category_update(\n    icompany bpchar,\n    iraw_mat_cat_code bpchar,\n    iraw_mat_cat_desc bpchar\n) OWNER TO postgres;