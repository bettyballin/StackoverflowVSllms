Logger logger = new Logger("MyCategory");\n\nlogger.Info("Something happened");\nlogger.Warn("Something might go wrong");\nlogger.Error("Something went wrong", new Exception("Error details"));\nlogger.Fatal("Something went terribly wrong", new Exception("Fatal error details"));