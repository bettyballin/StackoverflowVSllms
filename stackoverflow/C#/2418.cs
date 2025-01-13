private void button1_Click(object sender, EventArgs e)\n    {\n        try\n        {\n            var f_oType = Type.GetTypeFromProgID("Project1.Class1");\n            var f_oInstance = Activator.CreateInstance(f_oType);\n            f_oType.InvokeMember("Test3", BindingFlags.InvokeMethod, null, f_oInstance, new object[] {});\n        }\n        catch(TargetInvocationException ex)\n        {\n            //no need to subtract -2147221504 if non custom error etc\n            int errorNumber = ((COMException)ex.InnerException).ErrorCode - (-2147221504);\n            MessageBox.Show(errorNumber.ToString() + ": " + ex.InnerException.Message);\n        }\n        catch(Exception ex)\n        { MessageBox.Show(ex.Message); }\n    }