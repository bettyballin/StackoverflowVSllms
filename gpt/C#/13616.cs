// Install log4net via NuGet\n// PM> Install-Package log4net\n\nusing log4net;\nusing log4net.Config;\n\n// Configure log4net in your Global.asax.cs\npublic class MvcApplication : System.Web.HttpApplication\n{\n    private static readonly ILog log = LogManager.GetLogger(typeof(MvcApplication));\n\n    protected void Application_Start()\n    {\n        XmlConfigurator.Configure();\n        log.Info("Application started");\n    }\n\n    protected void Application_BeginRequest()\n    {\n        log.Info($"Request for {Request.Url}");\n    }\n\n    protected void Application_Error()\n    {\n        Exception exception = Server.GetLastError();\n        log.Error("Unhandled exception", exception);\n    }\n}\n\n// log4net configuration in Web.config\n<configuration>\n  <configSections>\n    <section name="log4net" type="log4net.Config.Log4NetConfigurationSectionHandler, log4net" />\n  </configSections>\n  <log4net>\n    <appender name="RollingFileAppender" type="log4net.Appender.RollingFileAppender">\n      <file value="Logs/logfile.log" />\n      <appendToFile value="true" />\n      <rollingStyle value="Date" />\n      <datePattern value="yyyy-MM-dd" />\n      <layout type="log4net.Layout.PatternLayout">\n        <conversionPattern value="%date [%thread] %-5level %logger - %message%newline" />\n      </layout>\n    </appender>\n    <root>\n      <level value="INFO" />\n      <appender-ref ref="RollingFileAppender" />\n    </root>\n  </log4net>\n</configuration>