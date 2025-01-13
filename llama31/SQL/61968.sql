SELECT lesson.id, p1.first_name, p1.surname, start_time, instrument.name \nFROM  lesson, person AS p1, person AS p2, instrument\nWHERE lesson.student = p1.id\nAND   lesson.teacher = p2.id\nAND   instrument.id  = lesson.instrument_id\nAND   lesson.id NOT IN (SELECT lesson_id FROM invoice_lesson)\nORDER BY surname