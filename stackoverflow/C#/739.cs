if (!File.Exists(fileName)) throw new ArgumentException("...");            \nvar s = File.OpenText(fileName);