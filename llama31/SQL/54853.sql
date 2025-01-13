DECLARE\n  xml XMLTYPE := XMLTYPE('<?xml version="1.0"?>\n                            <users>\n                                <user>\n                                    <name>user1</name>\n                                </user>\n                                <user>\n                                    <name>user2</name>\n                                </user>\n                                <user>\n                                    <name>user3</name>\n                                </user>\n                            </users>');\nBEGIN\n  FOR rec IN (\n    SELECT *\n    FROM XMLTABLE('/users/user' PASSING xml\n                  COLUMNS name VARCHAR2(20) PATH 'name')\n  ) LOOP\n    DBMS_OUTPUT.PUT_LINE(rec.name);\n  END LOOP;\nEND;