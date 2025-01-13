CREATE TABLE Questions (\n    QuestionID INT PRIMARY KEY,\n    Title VARCHAR(255),\n    Body TEXT,\n    CreatedDate DATETIME,\n    AuthorID INT,\n    -- other metadata fields\n    INDEX (Title),\n    INDEX (CreatedDate)\n);