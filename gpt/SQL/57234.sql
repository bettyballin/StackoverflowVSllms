UPDATE DEST D \nSET \n    AAA = (SELECT MAX(Z.AAA) FROM OTHER O WHERE O.ID = D.ID),\n    BBB = (SELECT MAX(Z.BBB) FROM OTHER O WHERE O.ID = D.ID)\nWHERE EXISTS (SELECT 1 FROM OTHER O WHERE O.ID = D.ID)