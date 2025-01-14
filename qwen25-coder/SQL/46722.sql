DELIMITER //\n\nCREATE PROCEDURE sprocGetArticles()\nBEGIN\n    SELECT \n        a.id AS article_id,\n        a.title,\n        a.content,\n        COUNT(c.id) AS comment_count\n    FROM \n        articles a\n    LEFT JOIN \n        comments c ON a.id = c.article_id\n    GROUP BY \n        a.id, a.title, a.content;\nEND //\n\nDELIMITER ;