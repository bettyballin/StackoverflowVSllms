public class FailOnUnhandledDialogWatcher : DialogWatcher\n{\n    public override bool HandleDialog(Dialog dialog)\n    {\n        throw new Exception("Unexpected dialog appeared: " + dialog.Title);\n    }\n}