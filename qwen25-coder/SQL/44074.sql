CREATE OR REPLACE PROCEDURE serialize_row_to_xml(\n    p_table_name IN VARCHAR2,\n    p_row_id     IN ROWID,\n    p_xml_out    OUT CLOB) IS\n\n    l_query       CLOB;\n    l_blob        BLOB;\n    l_blob_length INTEGER;\n    l_clob_chunk  CLOB;\n    l_clob        CLOB;\nBEGIN\n    -- Construct dynamic SQL query to fetch all columns of the row\n    l_query := 'SELECT XMLSerialize(CONTENT xmltype(dbms_xmlgen.getxml(''SELECT * FROM ' || p_table_name || ' WHERE ROWID = :1'')) AS CLOB) FROM dual';\n\n    -- Execute the query and get the result in a CLOB\n    EXECUTE IMMEDIATE l_query INTO p_xml_out USING p_row_id;\n\n    -- Handle BLOBS by appending them as base64 encoded strings if necessary\n    FOR rec IN (SELECT column_name, data_type \n                FROM all_tab_columns \n                WHERE table_name = UPPER(p_table_name) AND data_type LIKE 'BLOB')\n    LOOP\n        l_query := 'SELECT ' || rec.column_name || ' FROM ' || p_table_name || ' WHERE ROWID = :1';\n        EXECUTE IMMEDIATE l_query INTO l_blob USING p_row_id;\n\n        IF l_blob IS NOT NULL THEN\n            -- Convert BLOB to base64 encoded CLOB chunk\n            DBMS_LOB.CREATETEMPORARY(l_clob_chunk, TRUE);\n            DBMS_LOB.CONVERTTOCLOB(l_clob_chunk, l_blob, DBMS_LOB.LOBMAXSIZE, 0, NLS_CHARSET_ID('AL32UTF8'), DBMS_LOB.DEFAULT_LANG_CTX, XMLTYPE.C1_NEW_BLOCK);\n\n            -- Now append this to the output XML\n            p_xml_out := p_xml_out || '<' || rec.column_name || '><xop:Include xmlns:xop="http://www.w3.org/2004/08/xop/include" href="cid:' || DBMS_RANDOM.STRING('A', 16) || '" /></' || rec.column_name || '>';\n            p_xml_out := p_xml_out || '<xop:Include>' || UTL_RAW.CAST_TO_VARCHAR2(UTL_ENCODE.BASE64_ENCODE(l_clob_chunk)) || '</xop:Include>';\n\n            DBMS_LOB.FREETEMPORARY(l_clob_chunk);\n        END IF;\n    END LOOP;\n\nEND serialize_row_to_xml;\n/