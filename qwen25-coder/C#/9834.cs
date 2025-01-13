class Program\n{\n    static void Main()\n    {\n        var logger = new FileLogger("app.log");\n\n        logger.Log("Startup", FileLogger.LogLevel.Info, "Application is starting.");\n        logger.Log("Calculation", FileLogger.LogLevel.Debug, "Performing calculation...");\n        logger.Log("ErrorHandling", FileLogger.LogLevel.Error, "An error occurred during calculation.");\n    }\n}