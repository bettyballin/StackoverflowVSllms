SET IDENTITY_INSERT CommReceipt ON;\n\n-- Your insert statement\nINSERT INTO CommReceipt (CR_Key, Column1, Column2)\nSELECT CR_Key, Column1, Column2 FROM StagingTable;\n\nSET IDENTITY_INSERT CommReceipt OFF;