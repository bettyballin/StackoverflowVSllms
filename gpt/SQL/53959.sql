CREATE TABLE Users (\n    user_id INT PRIMARY KEY,\n    username VARCHAR(255)\n);\n\nCREATE TABLE Questions (\n    question_id INT PRIMARY KEY,\n    question_text TEXT\n);\n\nCREATE TABLE UserAnswers (\n    user_id INT,\n    question_id INT,\n    PRIMARY KEY (user_id, question_id),\n    FOREIGN KEY (user_id) REFERENCES Users(user_id),\n    FOREIGN KEY (question_id) REFERENCES Questions(question_id)\n);