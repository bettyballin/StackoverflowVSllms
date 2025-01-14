drop table if exists exams;\ndrop table if exists question_bank;\ndrop table if exists anwser_bank;\n\ncreate table exams\n(\n    exam_id uniqueidentifier primary key,\n    exam_name varchar(50),\n);\n\ncreate table question_bank\n(\n    question_id uniqueidentifier primary key,\n    question_exam_id uniqueidentifier not null,\n    question_text varchar(1024) not null,\n    question_point_value decimal,\n    constraint fk_question_bank_exams foreign key (question_exam_id) references exams(exam_id)\n);\n\ncreate table anwser_bank\n(\n    answer_id           uniqueidentifier primary key,\n    answer_question_id  uniqueidentifier,\n    answer_text         varchar(1024),\n    answer_is_correct   bit\n);