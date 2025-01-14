-- Table for storing images\nCREATE TABLE images (\n    ID int(11) AUTO_INCREMENT PRIMARY KEY,\n    -- other image fields like filename, upload_date, etc.\n);\n\n-- Table for storing tags\nCREATE TABLE tags (\n    ID int(11) AUTO_INCREMENT PRIMARY KEY,\n    tag varchar(20) UNIQUE -- Ensures no duplicate tags\n);\n\n-- Junction table to associate images with tags\nCREATE TABLE image_tags (\n    imageID int(11),\n    tagID int(11),\n    PRIMARY KEY (imageID, tagID), -- Composite primary key\n    FOREIGN KEY (imageID) REFERENCES images(ID) ON DELETE CASCADE,\n    FOREIGN KEY (tagID) REFERENCES tags(ID) ON DELETE CASCADE\n);