CREATE OR REPLACE PACKAGE my_custom_sequence_pkg AS\n  FUNCTION nextval RETURN NUMBER;\nEND my_custom_sequence_pkg;\n\nCREATE OR REPLACE PACKAGE BODY my_custom_sequence_pkg AS\n  g_current_value NUMBER := 0; -- This should be initialized appropriately\n\n  FUNCTION nextval RETURN NUMBER IS\n    PRAGMA AUTONOMOUS_TRANSACTION;\n  BEGIN\n    g_current_value := g_current_value + 1; -- Increment logic\n    COMMIT;\n    RETURN g_current_value;\n  END nextval;\n\nBEGIN\n  -- Initialization code if needed\nEND my_custom_sequence_pkg;