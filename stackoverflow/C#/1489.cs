using System;\n\nnamespace WcfServiceLibrary1\n{\n    public class Service1 : IService1, IService2\n    {\n        public string GetData(int value)\n        {\n            return string.Format("You entered: {0}", value);\n        }\n\n        public CompositeType GetDataUsingDataContract(CompositeType composite)\n        {\n            if (composite.BoolValue)\n            {\n                composite.StringValue += "Suffix";\n            }\n            return composite;\n        }\n\n        public void DoWork()\n        {\n            Service2Reference.IService2 svc = null;\n            try\n            {\n                svc = new Service2Reference.Service2Client();\n                svc.DoWork();\n            }\n            finally\n            {\n                if (svc != null)\n                {\n                    ((IDisposable)svc).Dispose();\n                }\n            }\n        }\n    }\n}