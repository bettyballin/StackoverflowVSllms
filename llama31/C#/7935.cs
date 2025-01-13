[StructLayout(LayoutKind.Sequential)]\npublic struct BIG_INPUT_STRC\n{\n    // ...\n}\n\n[StructLayout(LayoutKind.Sequential)]\npublic struct BIG_OUTPUT_STRC\n{\n    // ...\n}\n\n[DllImport("yourdllname.dll", CallingConvention = CallingConvention.StdCall)]\npublic static extern void ProcessChunk(IntPtr p_prochdl, ref BIG_INPUT_STRC p_inparams, ref BIG_OUTPUT_STRC p_outparams);\n\n// Allocate buffer\nIntPtr buffer = Marshal.AllocHGlobal(1024);\n\n// Copy data into buffer\nbyte[] data = new byte[1024];\n// ...\nMarshal.Copy(data, 0, buffer, 1024);\n\n// Create input and output structs\nBIG_INPUT_STRC input = new BIG_INPUT_STRC();\n// ...\nBIG_OUTPUT_STRC output = new BIG_OUTPUT_STRC();\n\n// Call the DLL function\nProcessChunk(IntPtr.Zero, ref input, ref output);\n\n// Free the buffer\nMarshal.FreeHGlobal(buffer);