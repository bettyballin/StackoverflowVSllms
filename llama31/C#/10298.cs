using System;\nusing System.Data.SqlClient;\nusing System.Windows.Forms;\n\nnamespace WinFormsExample\n{\n    public partial class MainForm : Form\n    {\n        private readonly string _connectionString;\n\n        public MainForm()\n        {\n            InitializeComponent();\n\n            // Initialize connection string securely\n            _connectionString = GetConnectionStringFromSecureStore();\n        }\n\n        private void button1_Click(object sender, EventArgs e)\n        {\n            // Validate user input\n            string userInput = textBox1.Text.Trim();\n            if (string.IsNullOrEmpty(userInput))\n            {\n                MessageBox.Show("Please enter a value.");\n                return;\n            }\n\n            // Connect to database using secure connection string\n            using (SqlConnection connection = new SqlConnection(_connectionString))\n            {\n                connection.Open();\n\n                // Perform query with parameterized input\n                using (SqlCommand command = new SqlCommand("SELECT * FROM MyTable WHERE MyColumn = @MyColumn", connection))\n                {\n                    command.Parameters.AddWithValue("@MyColumn", userInput);\n\n                    using (SqlDataReader reader = command.ExecuteReader())\n                    {\n                        while (reader.Read())\n                        {\n                            // Process results\n                        }\n                    }\n                }\n            }\n        }\n\n        private string GetConnectionStringFromSecureStore()\n        {\n            // Implement a secure way to store and retrieve connection strings,\n            // such as using Windows Credential Manager or a secrets manager.\n            throw new NotImplementedException();\n        }\n    }\n}