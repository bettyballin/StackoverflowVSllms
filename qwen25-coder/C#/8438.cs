using System;\nusing System.Diagnostics;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("advapi32.dll", SetLastError = true, CharSet = CharSet.Auto)]\n    private static extern bool DuplicateHandle(IntPtr hSourceProcessHandle, IntPtr hSourceHandle,\n        IntPtr hTargetProcessHandle, out IntPtr lpTargetHandle, uint dwDesiredAccess, bool bInheritHandle, uint dwOptions);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern int GetPriorityClass(IntPtr hWndProcess);\n\n    [DllImport("kernel32.dll", SetLastError = true)]\n    private static extern bool CloseHandle(IntPtr hObject);\n\n    private const int DUPLICATE_SAME_ACCESS = 0x00000002;\n\n    static void Main()\n    {\n        try\n        {\n            string mutexName = @"Global\YourMutexName";\n            Mutex mutex;\n            bool hasHandle = false;\n            IntPtr handle = IntPtr.Zero;\n            \n            try\n            {\n                // Attempt to open the existing mutex.\n                mutex = Mutex.OpenExisting(mutexName);\n            }\n            catch (WaitHandleCannotBeOpenedException e)\n            {\n                Console.WriteLine("Named Mutex does not exist. {0}", e.Message);\n                return;\n            }\n\n            using (mutex)\n            {\n                try\n                {\n                    // Get a handle to the current process.\n                    IntPtr currentProcess = Process.GetCurrentProcess().Handle;\n\n                    // Try to duplicate the mutex handle in our own process space, this will only work if we are the owner.\n                    hasHandle = DuplicateHandle(currentProcess, mutex.Handle, currentProcess, out handle, 0, false, DUPLICATE_SAME_ACCESS);\n                }\n                finally\n                {\n                    if (hasHandle)\n                        CloseHandle(handle);\n                }\n\n                string ownerName = IdentifyMutexOwner(mutex.Name);\n                Console.WriteLine("Current Mutex Owner: " + (!string.IsNullOrEmpty(ownerName) ? ownerName : "Could not determine"));\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine($"An error occurred: {ex.Message}");\n        }\n    }\n\n    private static string IdentifyMutexOwner(string mutexName)\n    {\n        foreach (Process p in Process.GetProcesses())\n        {\n            try\n            {\n                // Get a handle to the current process.\n                IntPtr h = p.Handle;\n\n                // Try to duplicate the event handle with PROCESS_QUERY_INFORMATION access.\n                if (DuplicateHandle(h, new IntPtr(Convert.ToInt32(mutexName.Replace("\\", ""), 16)), IntPtr.Zero, out IntPtr hDup,\n                    SYNCHRONIZE | MUTEX_MODIFY_STATE, false, DUPLICATE_SAME_ACCESS))\n                {\n                    CloseHandle(hDup);\n                    return p.ProcessName;\n                }\n            }\n            catch\n            {\n                // Ignore errors accessing processes and continue with others.\n            }\n        }\n\n        return null;\n    }\n\n    private const uint SYNCHRONIZE = 0x00100000;\n    private const uint MUTEX_MODIFY_STATE = 0x00000001;\n}