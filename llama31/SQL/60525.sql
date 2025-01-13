BEGIN\n  DBMS_SPACE.OBJECT_SPACE_USE(\n    segment_owner => 'your_schema',\n    segment_name => 'your_table_name',\n    segment_type => 'TABLE',\n    space_used => space_used,\n    space_allocated => space_allocated);\n  DBMS_OUTPUT.PUT_LINE('Estimated space used: ' || space_used);\nEND;