CREATE TABLE questions (\n    questionId INT PRIMARY KEY AUTO_INCREMENT,\n    userId INT NOT NULL,\n    title TEXT NOT NULL\n);\n\nCREATE TABLE votes (\n    voteId INT PRIMARY KEY AUTO_INCREMENT,\n    questionId INT NOT NULL,\n    userId INT NOT NULL,\n    FOREIGN KEY (questionId) REFERENCES questions(questionId),\n    FOREIGN KEY (userId) REFERENCES users(userId)\n);