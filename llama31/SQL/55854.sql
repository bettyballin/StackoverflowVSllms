CREATE OR REPLACE FUNCTION public.storeopeninghours_tostring(numeric)\n  RETURNS TABLE (column1 text, column2 text, column3 text) AS\nDECLARE\n  open_id ALIAS FOR $1;\nBEGIN\n  RETURN NEXT ('1', '2', '3');\n  RETURN NEXT ('3', '4', '5');\n  RETURN NEXT ('3', '4', '5');\n  RETURN;\nEND;