var usr = db.Users.From(uid => uid.dsiglas == userID && \n            uid.codigousuario == passID).FirstOrDefault();\n\nif(usr != null)\n   //Authenticate user here