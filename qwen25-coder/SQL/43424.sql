CREATE OR REPLACE FUNCTION unaccent(p_string IN VARCHAR2) \nRETURN VARCHAR2 IS\nBEGIN\n    RETURN LOWER(\n        REGEXP_REPLACE(\n            p_string,\n             '[áäâàåæ]', 'a')||\n        REGEXP_REPLACE(\n            p_string,\n            '[éëèê]', 'e')||\n        REGEXP_REPLACE(\n            p_string,\n            '[íïìî]', 'i')||\n        REGEXP_REPLACE(\n            p_string,\n            '[óöòôõøœ]', 'o')||\n        REGEXP_REPLACE(\n            p_string,\n            '[úüùûµ]', 'u'));\nEND;