this.scrolledwindow1.ButtonPressEvent += HandleButtonPressEvent;\n\n[GLib.ConnectBefore]\npublic void HandleButtonPressEvent(object o, ButtonPressEventArgs args)\n{\n    if (args.Event.Button == 3) // Right mouse button\n    {\n        Gtk.Menu mbox = new Gtk.Menu();\n        Gtk.MenuItem Test = new Gtk.MenuItem("test");\n        Test.Activated += delegate(object sender, EventArgs e) {\n            Console.WriteLine("test");\n        };\n        mbox.Append(Test);\n        mbox.ShowAll();\n        mbox.Popup(null, null, null, args.Event.Button, args.Event.Time);\n    }\n}