using System;\nusing System.Collections;\nusing System.Configuration.Install;\nusing System.IO;\nusing System.Text;\n\nnamespace CustomAction\n{\n    [RunInstaller(true)]\n    public partial class CustomAction : Installer\n    {\n        public override void Install(IDictionary stateSaver)\n        {\n            base.Install(stateSaver);\n\n            // Get the CustomActionData property\n            string customActionData = this.Context.Parameters["CustomActionData"];\n\n            // Split the CustomActionData string to get the individual values\n            string[] values = customActionData.Split(';');\n\n            // Access the values\n            string textBox1Value = values[0];\n            string textBox2Value = values[1];\n\n            // Use the values as needed\n            // ...\n        }\n    }\n}