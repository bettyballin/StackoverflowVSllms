-- Rows where num is NULL will not be returned,\n-- contrary to many users' expectations.\nSELECT * FROM sometable WHERE num <> 1;   \n             