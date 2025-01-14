SELECT lesson.id, p1.first_name, p1.surname, start_time, instrument.name \nFROM lesson\nJOIN person AS p1 ON lesson.student = p1.id\nJOIN person AS p2 ON lesson.teacher = p2.id\nJOIN instrument ON instrument.id = lesson.instrument_id\nWHERE NOT EXISTS (\n    SELECT 1 \n    FROM invoice_lesson \n    WHERE invoice_lesson.lesson_id = lesson.id\n)\nORDER BY surname;