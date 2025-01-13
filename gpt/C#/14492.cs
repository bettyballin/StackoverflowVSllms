using System;\n   using System.IO;\n   using System.Web;\n\n   public class Global : HttpApplication\n   {\n       protected void Application_EndRequest(object sender, EventArgs e)\n       {\n           if (Context.Trace.IsEnabled)\n           {\n               string traceInfo = Context.Trace.WriteToString();\n               string logFilePath = HttpContext.Current.Server.MapPath("~/App_Data/TraceLog.txt");\n\n               // Append the trace information to a log file\n               File.AppendAllText(logFilePath, traceInfo);\n           }\n       }\n   }