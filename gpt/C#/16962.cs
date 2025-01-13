using System;\nusing System.Runtime.InteropServices;\nusing System.Threading;\n\nclass Program\n{\n    // Import the WaitForSingleObject function from kernel32.dll\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern uint WaitForSingleObject(IntPtr hHandle, uint dwMilliseconds);\n\n    private const uint WAIT_OBJECT_0 = 0x00000000;\n    private const uint INFINITE = 0xFFFFFFFF;\n\n    static void Main()\n    {\n        // Create a ManualResetEvent for demonstration\n        using (ManualResetEvent manualEvent = new ManualResetEvent(false))\n        {\n            // Start a thread to signal the event after 2000 milliseconds\n            new Thread(() =>\n            {\n                Thread.Sleep(2000);\n                manualEvent.Set();\n            }).Start();\n\n            // Get the SafeWaitHandle and wait without pumping messages\n            IntPtr handle = manualEvent.SafeWaitHandle.DangerousGetHandle();\n            uint result = WaitForSingleObject(handle, INFINITE);\n\n            if (result == WAIT_OBJECT_0)\n            {\n                Console.WriteLine("WaitHandle was signaled.");\n            }\n            else\n            {\n                Console.WriteLine("WaitForSingleObject failed.");\n            }\n        }\n    }\n}