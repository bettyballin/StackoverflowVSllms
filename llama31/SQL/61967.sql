SELECT lesson.id, p1.first_name, p1.surname, start_time, instrument.name \nFROM  lesson, person AS p1, person AS p2, instrument\nLEFT JOIN invoice_lesson ON lesson.id = invoice_lesson.lesson_id\nWHERE lesson.student = p1.id\nAND   lesson.teacher = p2.id\nAND   instrument.id  = lesson.instrument_id\nAND   invoice_lesson.lesson_id IS NULL\nORDER BY surname