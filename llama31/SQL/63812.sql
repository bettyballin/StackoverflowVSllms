ALTER TABLE Users\nALTER COLUMN Email nvarchar(255) NOT NULL;\n\nALTER TABLE Users\nALTER COLUMN UserName nvarchar(255) NOT NULL;\n\nALTER TABLE Users\nADD CONSTRAINT UC_Users_Email UNIQUE (Email);\n\nALTER TABLE Users\nADD CONSTRAINT UC_Users_UserName UNIQUE (UserName);