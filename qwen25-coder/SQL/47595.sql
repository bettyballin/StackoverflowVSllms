CREATE OR REPLACE FUNCTION escape_regex_special_chars(p_input VARCHAR2)\nRETURN VARCHAR2 IS\n  v_escaped VARCHAR2(32767);\nBEGIN\n  -- Escape backslash first since it is used for escaping other characters\n  v_escaped := REGEXP_REPLACE(p_input, '\\', '\\\\');\n  \n  -- Escape other regex special chars\n  FOR char IN (SELECT '''' || chr || '''' AS escchar FROM (\n    SELECT DISTINCT chr FROM (\n      SELECT '\^-[]{}()*+?|.' chr FROM DUAL UNION ALL\n      SELECT chr FROM (SELECT level chr FROM dual CONNECT BY level <= 255) \n      WHERE chr NOT BETWEEN '0' AND '9'\n        AND chr NOT BETWEEN 'A' AND 'Z'\n        AND chr NOT BETWEEN 'a' AND 'z'\n    )\n  ))\n  LOOP\n    v_escaped := REGEXP_REPLACE(v_escaped, char.escchar, '\\' || char.escchar);\n  END LOOP;\n  \n  RETURN v_escaped;\nEND escape_regex_special_chars;\n/