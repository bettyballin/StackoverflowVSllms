if (this.InvokeRequired)\n   {\n       this.Invoke(new MethodInvoker(delegate\n       {\n           // Access COM object here\n       }));\n   }\n   else\n   {\n       // Access COM object here\n   }