[DllImport("CreateCodeDLL.dll", CallingConvention = CallingConvention.StdCall, CharSet = CharSet.Ansi)]\npublic static extern IntPtr CreateCode(\n    string SerialID,\n    UInt16 StartDateOfYear,\n    UInt16 YearOfStartDate,\n    UInt16 YearOfEndDate,\n    UInt16 DatePeriod,\n    Byte CodeType,\n    Byte RecordNumber,\n    Byte StartHour,\n    Byte EndHour);\n\n// ...\n\n// Call the DLL method\nIntPtr codePtr = CodeGenerator.CreateCode(serialID, StartDateOfYear, YearOfStartDate, YearOfEndDate, DatePeriod, CodeType, RecordNumber, StartHour, EndHour);\n\n// Extract the code string and free the memory\nstring code = Marshal.PtrToStringAnsi(codePtr);\nMarshal.FreeHGlobal(codePtr); // Free the memory allocated by the DLL