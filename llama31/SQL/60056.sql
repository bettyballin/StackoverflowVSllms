SELECT  ARTICLE_NO\nFROM    auctions1\nWHERE   (date_format(str_to_date(ACCESSSTARTS, '%d/%m/%Y %k:%i:%s'), '%Y-%m-%d'), article_no) > \n        (\n        SELECT  date_format(str_to_date(ACCESSSTARTS, '%d/%m/%Y %k:%i:%s'), '%Y-%m-%d'), article_no\n        FROM    auctions1\n        WHERE   ARTICLE_NO = 160288212077\n        )\nORDER BY \n        str_to_date(ACCESSSTARTS, '%d/%m/%Y %k:%i:%s'), article_no\nLIMIT 1;