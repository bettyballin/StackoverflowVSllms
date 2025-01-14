-- Table for Teams\nCREATE TABLE Teams (\n    TeamID INT PRIMARY KEY,\n    TeamName VARCHAR(255) NOT NULL,\n    Seed INT\n);\n\n-- Table for Rounds (Stages in the tournament)\nCREATE TABLE Rounds (\n    RoundID INT PRIMARY KEY,\n    RoundName VARCHAR(100)  -- e.g., 'Round of 64', 'Championship'\n);\n\n-- Table for Matches linking Teams and Rounds\nCREATE TABLE Matches (\n    MatchID INT PRIMARY KEY,\n    TeamA_ID INT,       -- Foreign Key to Teams\n    TeamB_ID INT,       -- Foreign Key to Teams\n    WinnerTeam_ID INT,  -- Optionally stores the winning team's ID directly from here\n    RoundID INT,        -- Foreign Key to Rounds\n    FOREIGN KEY (TeamA_ID) REFERENCES Teams(TeamID),\n    FOREIGN KEY (TeamB_ID) REFERENCES Teams(TeamID),\n    FOREIGN KEY (RoundID) REFERENCES Rounds(RoundID)\n);\n\n-- Table for Scores\nCREATE TABLE Scores (\n    ScoreID INT PRIMARY KEY,\n    MatchID INT,        -- Foreign Key to Matches\n    TeamA_Score INT,\n    TeamB_Score INT,\n    WinnerTeam_ID INT,  -- Also store here for fast lookup purposes if necessary\n    FOREIGN KEY (MatchID) REFERENCES Matches(MatchID)\n);