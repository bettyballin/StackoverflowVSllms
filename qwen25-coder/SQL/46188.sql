-- For typeenvoi='EXPORT'\nEXPLAIN SELECT numenvoi,adrdest,nomdest,etat,nbessais,numappel,description,typeperiode,datedebut,datefin,codeetat,codecontrat,typeenvoi,dateentree,dateemission,typedoc,numdiffusion,nature,commentaire,criselcomp,crisite,criservice,chrono,codelangueetat,piecejointe, sujetmail, textemail\nFROM v_envoiautomate\nWHERE etat=0 AND typeenvoi='EXPORT' AND nbessais<1;\n\n-- For typeenvoi='MAIL'\nEXPLAIN SELECT numenvoi,adrdest,nomdest,etat,nbessais,numappel,description,typeperiode,datedebut,datefin,codeetat,codecontrat,typeenvoi,dateentree,dateemission,typedoc,numdiffusion,nature,commentaire,criselcomp,crisite,criservice,chrono,codelangueetat,piecejointe, sujetmail, textemail\nFROM v_envoiautomate\nWHERE etat=0 AND typeenvoi='MAIL' AND nbessais<1;