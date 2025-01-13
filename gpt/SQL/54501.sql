SELECT ARTICLE_NO, USERNAME, ACCESSSTARTS, ARTICLE_NAME, \ndate_format(str_to_date(ACCESSSTARTS, '%d.%m.%Y %k:%i:%s'), '%d %m %Y' ) AS shortDate \nFROM AUCTIONS WHERE SUBCAT = 'fake' AND USERNAME = 'testuser' \nORDER BY str_to_date(ACCESSSTARTS, '%d.%m.%Y %k:%i:%s'), article_no \nLIMIT 0, 10;