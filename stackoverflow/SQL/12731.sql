SELECT IIf(InStr([FileName],""\"")>0,Mid$([Filename],InStrRev([Filename],""\"")+1),[Filename]) FROM Table1