SELECT username, cardName, MIN(timeStamp) AS firstTimeStamp, msToAnswer\nFROM usercardinfo\nGROUP BY username, cardName\nORDER BY username, cardName;