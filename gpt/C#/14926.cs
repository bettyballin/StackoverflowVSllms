using System;\nusing System.Security.Cryptography;\nusing System.Text;\nusing System.Windows.Forms;\n\npublic class SecurePasswordStorage\n{\n    // Method to encrypt the password\n    public static byte[] EncryptPassword(string password)\n    {\n        return ProtectedData.Protect(Encoding.UTF8.GetBytes(password), null, DataProtectionScope.CurrentUser);\n    }\n\n    // Method to decrypt the password\n    public static string DecryptPassword(byte[] encryptedPassword)\n    {\n        return Encoding.UTF8.GetString(ProtectedData.Unprotect(encryptedPassword, null, DataProtectionScope.CurrentUser));\n    }\n\n    // Example usage in a WinForms application\n    public static void Main()\n    {\n        // Prompt the user to enter the password\n        string password = Prompt.ShowDialog("Enter Password:", "Secure Password Storage");\n\n        // Encrypt the password\n        byte[] encryptedPassword = EncryptPassword(password);\n\n        // Store the encrypted password securely (e.g., in a settings file, database, etc.)\n        // For demonstration purposes, we'll just decrypt it immediately\n        string decryptedPassword = DecryptPassword(encryptedPassword);\n\n        MessageBox.Show($"Encrypted Password: {Convert.ToBase64String(encryptedPassword)}\nDecrypted Password: {decryptedPassword}");\n    }\n}\n\n// Helper class to prompt user input\npublic static class Prompt\n{\n    public static string ShowDialog(string text, string caption)\n    {\n        Form prompt = new Form()\n        {\n            Width = 500,\n            Height = 150,\n            Text = caption\n        };\n\n        Label textLabel = new Label() { Left = 50, Top = 20, Text = text };\n        TextBox textBox = new TextBox() { Left = 50, Top = 50, Width = 400, UseSystemPasswordChar = true };\n        Button confirmation = new Button() { Text = "Ok", Left = 350, Width = 100, Top = 70, DialogResult = DialogResult.OK };\n\n        confirmation.Click += (sender, e) => { prompt.Close(); };\n        prompt.Controls.Add(textLabel);\n        prompt.Controls.Add(textBox);\n        prompt.Controls.Add(confirmation);\n        prompt.AcceptButton = confirmation;\n\n        return prompt.ShowDialog() == DialogResult.OK ? textBox.Text : "";\n    }\n}