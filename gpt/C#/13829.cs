using Owin;\n    public class Startup\n    {\n        public void Configuration(IAppBuilder app)\n        {\n            app.MapSignalR();\n        }\n    }