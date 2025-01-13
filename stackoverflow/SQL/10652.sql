SELECT \n   ACCESSSTARTS, \n   date_format(str_to_date(ACCESSSTARTS, '%d.%m.%Y %k:%i:%s'), '%d %m %Y' ) AS shortDate\nFROM AUCTIONS \nWHERE upper( ARTICLE_NAME ) LIKE '%hardy%' \nLIMIT 0 , 10;