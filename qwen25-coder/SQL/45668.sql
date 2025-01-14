SELECT \n    t1.id AS postId,\n    t1.title AS postTitle,\n    t2.create AS postCreate,\n    t3.username AS authorUsername,\n    t4.title AS authorUserTitle,\n    t3.permission AS authorPermission,\n    cm.create AS lastCommentCreate,\n    cm.authorID AS lastCommentAuthorId,\n    ucm.username AS lastCommentAuthorUsername,\n    ucm.permission AS lastCommentAuthorPermission\nFROM \n    postit AS t1\nLEFT JOIN \n    postitInfo AS t2 ON t1.id = t2.referencePostitID\nLEFT JOIN \n    (SELECT authorId, title FROM user INNER JOIN userInfo ON user.id = userInfo.referenceUserID) AS t3 ON t2.authorId = t3.authorId\nLEFT JOIN \n    (\n        SELECT referenceID, MAX(create) as max_create\n        FROM commentInfo\n        WHERE referenceType = 8\n        GROUP BY referenceID\n    ) recentComments ON t1.id = recentComments.referenceID\nLEFT JOIN \n    commentInfo cm ON recentComments.referenceID = cm.referenceID AND recentComments.max_create = cm.create\nLEFT JOIN \n    (SELECT id, username, permission FROM user) ucm ON cm.authorID = ucm.id\nORDER BY \n    postCreate DESC, lastCommentCreate DESC;