-- Table structure example\nCREATE TABLE Posts (\n    PostID INT PRIMARY KEY,\n    Title NVARCHAR(255),\n    Content TEXT,\n    CommentCount INT DEFAULT 0\n);