SELECT Documents.name, HasDownloaded.id \nFROM Documents\nLEFT JOIN HasDownloaded ON HasDownloaded.documentID = Documents.id AND HasDownloaded.memberID = @memberID;