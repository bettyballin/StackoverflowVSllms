using ScintillaNET;\nusing System;\nusing System.Windows.Forms;\n\nnamespace SyntaxHighlightingExample\n{\n    public partial class MainForm : Form\n    {\n        private Scintilla scintilla;\n\n        public MainForm()\n        {\n            InitializeComponent();\n            InitializeScintilla();\n        }\n\n        private void InitializeScintilla()\n        {\n            scintilla = new Scintilla\n            {\n                Dock = DockStyle.Fill\n            };\n            this.Controls.Add(scintilla);\n\n            // Set the lexer for C# syntax highlighting\n            scintilla.Lexer = Lexer.Cpp;\n\n            // Set the styles for C# syntax highlighting\n            scintilla.Styles[Style.Cpp.Default].ForeColor = System.Drawing.Color.Silver;\n            scintilla.Styles[Style.Cpp.Comment].ForeColor = System.Drawing.Color.Green;\n            scintilla.Styles[Style.Cpp.CommentLine].ForeColor = System.Drawing.Color.Green;\n            scintilla.Styles[Style.Cpp.Number].ForeColor = System.Drawing.Color.Olive;\n            scintilla.Styles[Style.Cpp.Word].ForeColor = System.Drawing.Color.Blue;\n            scintilla.Styles[Style.Cpp.Word2].ForeColor = System.Drawing.Color.Blue;\n            scintilla.Styles[Style.Cpp.String].ForeColor = System.Drawing.Color.Red;\n            scintilla.Styles[Style.Cpp.Character].ForeColor = System.Drawing.Color.Red;\n            scintilla.Styles[Style.Cpp.Operator].ForeColor = System.Drawing.Color.Purple;\n\n            // Set the keywords for C# syntax highlighting\n            scintilla.SetKeywords(0, "abstract as base bool break byte case catch char checked class const continue decimal default delegate do double else enum event explicit extern false finally fixed float for foreach goto if implicit in int interface internal is lock long namespace new null object operator out override params private protected public readonly ref return sbyte sealed short sizeof stackalloc static string struct switch this throw true try typeof uint ulong unchecked unsafe ushort using virtual void volatile while");\n\n            scintilla.SetKeywords(1, "get set value add remove alias ascending descending from group into join let orderby select where yield");\n        }\n\n        [STAThread]\n        static void Main()\n        {\n            Application.EnableVisualStyles();\n            Application.SetCompatibleTextRenderingDefault(false);\n            Application.Run(new MainForm());\n        }\n    }\n}