CREATE OR REPLACE FUNCTION get_date_range RETURN DATE IS\nBEGIN\n  RETURN TRUNC(SYSDATE - 100 * 365.25); -- 100 years ago\nEND;\n/\n\nCREATE OR REPLACE FUNCTION get_tomorrow RETURN DATE IS\nBEGIN\n  RETURN TRUNC(SYSDATE) + 1; -- tomorrow\nEND;\n/\n\nALTER TABLE your_table\nADD CONSTRAINT birth_date_chk\nCHECK (BIRTH_DATE >= get_date_range AND BIRTH_DATE < get_tomorrow);