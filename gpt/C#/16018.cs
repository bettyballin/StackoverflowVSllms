using System;\nusing Microsoft.FlightSimulator.SimConnect;\n\nclass Program\n{\n    private static SimConnect simconnect = null;\n\n    static void Main(string[] args)\n    {\n        try\n        {\n            simconnect = new SimConnect("Managed Data Request", IntPtr.Zero, 0, null, 0);\n\n            simconnect.OnRecvOpen += new SimConnect.RecvOpenEventHandler(SimConnect_OnRecvOpen);\n            simconnect.OnRecvQuit += new SimConnect.RecvQuitEventHandler(SimConnect_OnRecvQuit);\n            simconnect.OnRecvSimobjectData += new SimConnect.RecvSimobjectDataEventHandler(SimConnect_OnRecvSimobjectData);\n\n            // Define the data structure\n            simconnect.AddToDataDefinition(DEFINITIONS.Struct1, "Airspeed Indicated", "knots", SIMCONNECT_DATATYPE.FLOAT64, 0.0f, SimConnect.SIMCONNECT_UNUSED);\n            simconnect.AddToDataDefinition(DEFINITIONS.Struct1, "Plane Altitude", "feet", SIMCONNECT_DATATYPE.FLOAT64, 0.0f, SimConnect.SIMCONNECT_UNUSED);\n            simconnect.RegisterDataDefineStruct<Struct1>(DEFINITIONS.Struct1);\n\n            // Request data on a specific interval\n            simconnect.RequestDataOnSimObjectType(DATA_REQUESTS.REQUEST_1, DEFINITIONS.Struct1, 0, SIMCONNECT_SIMOBJECT_TYPE.USER);\n\n            // Keep the application running\n            while (true)\n            {\n                simconnect.ReceiveMessage();\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Exception: " + ex.Message);\n        }\n    }\n\n    private static void SimConnect_OnRecvOpen(SimConnect sender, SIMCONNECT_RECV_OPEN data)\n    {\n        Console.WriteLine("Connected to Flight Simulator");\n    }\n\n    private static void SimConnect_OnRecvQuit(SimConnect sender, SIMCONNECT_RECV data)\n    {\n        Console.WriteLine("Flight Simulator has exited");\n        Environment.Exit(0);\n    }\n\n    private static void SimConnect_OnRecvSimobjectData(SimConnect sender, SIMCONNECT_RECV_SIMOBJECT_DATA data)\n    {\n        if (data.dwRequestID == (uint)DATA_REQUESTS.REQUEST_1)\n        {\n            Struct1 s1 = (Struct1)data.dwData[0];\n            Console.WriteLine("Airspeed: " + s1.airspeed + " knots, Altitude: " + s1.altitude + " feet");\n        }\n    }\n\n    enum DEFINITIONS\n    {\n        Struct1\n    }\n\n    enum DATA_REQUESTS\n    {\n        REQUEST_1\n    }\n\n    [StructLayout(LayoutKind.Sequential, CharSet = CharSet.Ansi, Pack = 1)]\n    struct Struct1\n    {\n        public double airspeed;\n        public double altitude;\n    }\n}