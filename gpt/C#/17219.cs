public partial class CaseNoteForm : Form\n{\n    private CaseNote _caseNote;\n\n    public CaseNoteForm(CaseNote caseNote)\n    {\n        InitializeComponent();\n        _caseNote = caseNote;\n        // Initialize form fields with _caseNote data\n    }\n}