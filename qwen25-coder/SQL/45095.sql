CREATE FULLTEXT INDEX ON Pets(Name)\nKEY INDEX PK_Pets \nON MyFTCatalog;\n\nCREATE FULLTEXT INDEX ON PetOtherNames(Name)\nKEY INDEX PK_PetOtherNames \nON MyFTCatalog;