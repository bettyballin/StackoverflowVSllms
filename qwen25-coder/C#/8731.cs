IRunningObjectTable rot = null;\n     IBindCtx bindCtx = null;\n     IMoniker moniker = null;\n\n     try\n     {\n         RotFlags flags = RotFlags.None;\n         CreateBindCtx(0, out bindCtx);\n         bindCtx.SetAuthenticationLevel(AuthenticationLevels.Connect);\n         // ... existing code ...\n     }\n     finally\n     {\n         if (rot != null) Marshal.ReleaseComObject(rot);\n         if (bindCtx != null) Marshal.ReleaseComObject(bindCtx);\n         if (moniker != null) Marshal.ReleaseCOMObject(moniker);\n     }