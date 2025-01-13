using SIPSorcery.SIP;\nusing SIPSorcery.SIP.App;\nusing System;\n\nnamespace SIPDialer\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            var sipTransport = new SIPTransport();\n\n            var userAgent = new SIPUserAgent(sipTransport, null);\n            var serverUri = SIPURI.ParseSIPURI("sip:your.sip.server.com");\n            var fromHeader = new SIPFromHeader("username", SIPURI.ParseSIPURI("sip:username@your.sip.server.com"), null);\n            var toHeader = new SIPToHeader(null, SIPURI.ParseSIPURI("sip:target@your.sip.server.com"), null);\n\n            var callDescriptor = new SIPCallDescriptor("username", "password", serverUri.ToString(), toHeader.ToString(), fromHeader.ToString(), null, null, null, SIPCallDirection.Out, null, null);\n\n            userAgent.OnCallHungup += (dialog) => Console.WriteLine("Call hung up.");\n            userAgent.OnCallAnswered += (dialog) => Console.WriteLine("Call answered.");\n            userAgent.OnCallFailed += (dialog, reason) => Console.WriteLine($"Call failed: {reason}");\n\n            userAgent.Call(callDescriptor);\n\n            Console.WriteLine("Press any key to exit...");\n            Console.ReadKey();\n        }\n    }\n}