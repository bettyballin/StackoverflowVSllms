UPDATE Ordre\nSET SamletPris = (SELECT SUM(Vare.Pris * VareOrdre.Antal)\n                  FROM Vare\n                  JOIN VareOrdre ON Vare.Vnr = VareOrdre.Vnr\n                  WHERE Ordre.Onr = 100 AND Ordre.Onr = VareOrdre.Onr)\nWHERE Onr = 100;