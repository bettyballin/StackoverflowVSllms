CREATE OR REPLACE FUNCTION AssociativeArrayToTable(\n  p_assoc_array AssocArray_Date_t\n) RETURN TABLE OF DATE PIPELINED IS\nBEGIN\n  FOR i IN 1..p_assoc_array.COUNT LOOP\n    PIPE ROW (p_assoc_array(i));\n  END LOOP;\n  RETURN;\nEND;