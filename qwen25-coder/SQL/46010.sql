SELECT \n    Items.itemID,\n    Items.itemTitle,\n    MyList.deleted,\n    MyList.userID\nFROM \n    Items\nLEFT JOIN \n    MyList ON Items.itemID = MyList.itemID;