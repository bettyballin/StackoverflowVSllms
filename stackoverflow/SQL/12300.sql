(SELECT news.newsTitle AS title, news.newsBody AS body, \nDATE_FORMAT( news.postedOn,  '%M %d, %Y' ) AS posted,\nnews.postedOn, null AS image, null AS score\nFROM news)\nUNION ALL\n(SELECT game.gameName as title, review.reviewSummary AS body,\nDATE_FORMAT( review.postedOn,  '%M %d, %Y' ) AS posted,\nreview.postedOn, game.gameImage AS image, review.ourScore AS score\nFROM game LEFT JOIN review ON game.gameID = review.gameID \nWHERE game.isPublished = 'y')    \nORDER BY postedOn DESC\nLIMIT 0,5