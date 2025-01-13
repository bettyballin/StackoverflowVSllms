using System.Runtime.CompilerServices;\nusing System.Runtime.InteropServices;\n\n\n/// <summary>\n/// A COM interface is needed because .NET does not provide a way\n/// to set the properties of a HTML script element.\n/// This class negates the need to refrence mshtml in its entirety\n/// </summary>\n[ComImport, Guid("3050F536-98B5-11CF-BB82-00AA00BDCE0B"),\nInterfaceType((short)2),\nTypeLibType((short)0x4112)]\npublic interface IHTMLScriptElement\n{\n    /// <summary>\n    /// Sets the text property\n    /// </summary>\n    [DispId(1006)]\n    string Text\n    {\n        [param: MarshalAs(UnmanagedType.BStr)]\n        [PreserveSig,\n        MethodImpl(MethodImplOptions.InternalCall, MethodCodeType = MethodCodeType.Runtime),\n        DispId(-2147417085)]\n        set;\n    }\n\n    /// <summary>\n    /// Sets the src property\n    /// </summary>\n    [DispId(1001)]\n    string Src\n    {\n        [param: MarshalAs(UnmanagedType.BStr)]\n        [PreserveSig,\n        MethodImpl(MethodImplOptions.InternalCall, MethodCodeType = MethodCodeType.Runtime),\n        DispId(-1001)]\n        set;\n    }\n}\n\n// Inject script element\npublic static void InjectJavascript(string javascript, HTMLDocument doc)\n{\n    if (doc != null)\n    {\n        try\n        {\n            // find the opening head tag\n            HtmlElement head =  doc.GetElementsByTagName("head")[0];\n            // create the script element\n            HtmlElement script =  doc.CreateElement("script");\n            // set it to javascirpt\n            script.SetAttribute("type", "text/javascript");\n            // cast the element to our custom interface\n            IHTMLScriptElement element = (IHTMLScriptElement)script.DomElement;\n            // add the script code to the element\n            element.Text = "/* <![CDATA[ */ " + javascript + " /* ]]> */";\n            // add the element to the document\n            head.AppendChild(script);\n        }\n        catch (Exception e)\n        {\n            MessageBox.show(e.message);\n        }\n    }\n}