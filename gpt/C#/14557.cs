[ComImport, Guid("Your-COM-GUID-Here"), InterfaceType(ComInterfaceType.InterfaceIsIUnknown)]\n    public interface IMyComObject\n    {\n        void GetDIB(out IntPtr ppDIB, out uint pcbSize);\n    }\n\n    public Bitmap GetImageFromCom()\n    {\n        IMyComObject comObj = new MyComObject(); // Instantiate your COM object\n\n        comObj.GetDIB(out IntPtr pDIB, out uint cbSize);\n\n        if (pDIB == IntPtr.Zero || cbSize == 0)\n            throw new InvalidOperationException("Failed to get DIB from COM object.");\n\n        byte[] dibData = new byte[cbSize];\n        Marshal.Copy(pDIB, dibData, 0, (int)cbSize);\n\n        // Free the allocated memory if necessary\n        Marshal.FreeCoTaskMem(pDIB);\n\n        using (MemoryStream ms = new MemoryStream(dibData))\n        {\n            return new Bitmap(ms);\n        }\n    }