using Microsoft.AspNet.SignalR;\n\n     public class Startup\n     {\n         public void Configuration(IAppBuilder app)\n         {\n             app.MapSignalR();\n         }\n     }