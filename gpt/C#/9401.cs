using System.IO;\nusing System.Text;\n\nstring fileSobrantes = "path_to_your_file.txt";\nstring textToWrite = "SEGS,AUS1,1,0,0,712205,584,8659094,2,NUÑEZ   FELIX ARTURO,584";\n\nusing (StreamWriter sw = new StreamWriter(fileSobrantes, true, Encoding.UTF8))\n{\n    sw.WriteLine(textToWrite);\n}