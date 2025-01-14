CREATE OR REPLACE FUNCTION is_valid_email(email IN VARCHAR2) RETURN BOOLEAN IS\nBEGIN\n  RETURN REGEXP_LIKE(email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$');\nEND;\n/\n\nCREATE OR REPLACE FUNCTION is_valid_uk_postcode(postcode IN VARCHAR2) RETURN BOOLEAN IS\nBEGIN\n  RETURN REGEXP_LIKE(postcode, '^([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9]?[A-Za-z])))) [0-9][A-Za-z]{2})$');\nEND;\n/