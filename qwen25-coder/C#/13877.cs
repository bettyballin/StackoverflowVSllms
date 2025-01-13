using Gtk;\n\npublic class TextViewMenuExample : Window\n{\n    private Menu popupMenu;\n    private TextView textView;\n\n    public TextViewMenuExample() : base("TextView with Context Menu")\n    {\n        textView = new TextView();\n        Add(textView);\n\n        // Create a simple popup menu\n        popupMenu = new Menu();\n        var menuItem1 = new MenuItem("Copy");\n        popupMenu.Append(menuItem1);\n        \n        menuItem1.Activated += (sender, args) => \n            Console.WriteLine("Copy selected");\n\n        popupMenu.ShowAll();\n\n        // Handle right click event on TextView\n        textView.ButtonPressEvent += OnTextViewButtonPress;\n    }\n\n    private void OnTextViewButtonPress(object sender, ButtonPressEventArgs args)\n    {\n        if (args.Event.Type == Gdk.EventType.ButtonPress && args.Event.Button == 3)\n        {\n            popupMenu.Popup();\n        }\n    }\n\n    public static void Main()\n    {\n        Application.Init();\n        new TextViewMenuExample().ShowAll();\n        Application.Run();\n    }\n}