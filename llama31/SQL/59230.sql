SELECT     tblLEMSCredentialsId, TechNumber\nFROM         tblLEMSCredentials AS aLEMSCreds\nUNION ALL\nSELECT     NULL AS Expr1, '<NONE>' AS Expr2