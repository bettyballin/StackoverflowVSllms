void OnUpdated(EventArgs e) {\n   EventHandler h = this.Updated;\n   if (h != null) h(e);\n}\n\nvoid DoStuff() {\n   BigMethod();\n   ThreadPool.QueueUserWorkItem(OnUpdated, EventArgs.Empty);\n   BigMethod2();\n}