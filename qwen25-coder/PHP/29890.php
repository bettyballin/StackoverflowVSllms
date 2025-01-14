if ($getRecords = $con->prepare("SELECT ARTICLE_NO, ARTICLE_NAME, SUBTITLE, CURRENT_BID, START_PRICE, BID_COUNT, QUANT_TOTAL, QUANT_SOLD, ACCESSSTARTS, ACCESSENDS, ACCESSORIGIN_END, USERNAME, BEST_BIDDER_ID, FINISHED, WATCH, BUYITNOW_PRICE, PIC_URL, PRIVATE_AUCTION, AUCTION_TYPE, ACCESSINSERT_DATE, ACCESSUPDATE_DATE, CAT_DESC, CAT_PATH, COUNTRYCODE, LOCATION, CONDITIONS, REVISED, PAYPAL_ACCEPT, PRE_TERMINATED, SHIPPING_TO, FEE_INSERTION, FEE_FINAL, FEE_LISTING, PIC_XXL, PIC_DIASHOW, PIC_COUNT, ITEM_SITE_ID FROM AUCTIONS WHERE ARTICLE_NO = ?"))\n{\n    $getHtml = $con->prepare("SELECT ARTICLE_DESC FROM AUCTIONS WHERE ARTICLE_NO = ?");\n    $getHtml->bind_param("i", $pk);\n    $getHtml->execute();\n    $getHtml->bind_result($ARTICLE_DESC);\n\n    $getRecords->bind_param("i", $pk); \n    $getRecords->execute(); \n    $getRecords->bind_result($ARTICLE_NO, $ARTICLE_NAME, $SUBTITLE, $CURRENT_BID, $START_PRICE, $BID_COUNT, $QUANT_TOTAL, $QUANT_SOLD, $ACCESSSTARTS, $ACCESSENDS, $ACCESSORIGIN_END, $USERNAME, $BEST_BIDDER_ID, $FINISHED, $WATCH, $BUYITNOW_PRICE, $PIC_URL, $PRIVATE_AUCTION, $AUCTION_TYPE, $ACCESSINSERT_DATE, $ACCESSUPDATE_DATE, $CAT_DESC, $CAT_PATH, $COUNTRYCODE, $LOCATION, $CONDITIONS, $REVISED, $PAYPAL_ACCEPT, $PRE_TERMINATED, $SHIPPING_TO, $FEE_INSERTION, $FEE_FINAL, $FEE_LISTING, $PIC_XXL, $PIC_DIASHOW, $PIC_COUNT, $ITEM_SITE_ID);\n\n    while ($getRecords->fetch()) {\n        // Process your results here\n    }\n}