SELECT g.Game_Number, g.PutColumnsHere, count(t.Game_Number) \nFROM games g\nLEFT JOIN tickets t ON g.Game_Number = t.Game_Number\nGROUP BY g.Game_Number, g.PutColumnsHere