using System;\nusing System.Net.Http;\nusing System.Threading.Tasks;\nusing System.Windows.Forms;\n\nnamespace WebsiteMonitor\n{\n    public partial class MainForm : Form\n    {\n        private const string SiteUrl = "http://yourwebsiteurl.com";\n        private static readonly HttpClient Client = new HttpClient();\n        private Timer checkWebsiteTimer;\n\n        public MainForm()\n        {\n            InitializeComponent();\n            checkWebsiteTimer = new Timer { Interval = 60000 }; // Check every minute\n            checkWebsiteTimer.Tick += CheckWebsite;\n            checkWebsiteTimer.Start();\n        }\n\n        private async void CheckWebsite(object sender, EventArgs e)\n        {\n            try\n            {\n                HttpResponseMessage response = await Client.GetAsync(SiteUrl);\n\n                if (!response.IsSuccessStatusCode)\n                {\n                    ShowAlert($"Error: {response.StatusCode}");\n                }\n            }\n            catch (HttpRequestException ex)\n            {\n                ShowAlert($"HTTP Request Error: {ex.Message}");\n            }\n        }\n\n        private void ShowAlert(string message)\n        {\n            MessageBox.Show(message, "Website Alert", MessageBoxButtons.OK, MessageBoxIcon.Error);\n        }\n\n        [STAThread]\n        static void Main()\n        {\n            Application.EnableVisualStyles();\n            Application.SetCompatibleTextRenderingDefault(false);\n            Application.Run(new MainForm());\n        }\n    }\n}