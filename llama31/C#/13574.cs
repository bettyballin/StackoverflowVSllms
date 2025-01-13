amespace COMTest\n{\n    [ComVisible(true),\n    Guid("02271CDF-BDB9-4cfe-B65B-2FA58FF1F64B"),\n    InterfaceType(ComInterfaceType.InterfaceIsIDispatch)]\n    public interface ITestEvents\n    {\n        [DispId(1)]\n        void OnTest();\n    }\n\n    [ComVisible(true),\n    Guid("87BA4D3A-868E-4233-A324-30035154F8A4")]\n    public interface ITest\n    {\n        void RaiseTest();\n    } // End of ITest\n\n    [ComVisible(true),\n    Guid("410CD174-8933-4f8c-A799-8EE82AF4A9F2"),\n    ClassInterface(ClassInterfaceType.None),\n    ComSourceInterfaces(typeof(ITestEvents))]\n    public class TestImplimentation : ITest\n    {\n        public TestImplimentation()\n        {\n        }\n\n        public void RaiseTest()\n        {\n            if (null != OnTest)\n                OnTest();\n        }\n\n        [DispId(1)]\n        public event ITestEvents.OnTestEventHandler OnTest;\n    }\n}