CREATE TABLE Friends (\n       FriendId int PRIMARY KEY,\n       UserId int NOT NULL,\n       Name nvarchar(255),\n       PreviousFriendId int NULL,\n       NextFriendId int NULL\n   );