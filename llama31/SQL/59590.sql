SELECT SUBSTR(bom_course_id, LENGTH(bom_course_id) - INSTR(REVERSE(bom_course_id), '.') + 2)\nFROM ...