using System;\nusing System.Collections.Generic;\n\npublic class DeepLinkHandler\n{\n    private readonly HashSet<string> _allowedPages = new HashSet<string>()\n    {\n        "MyPage",\n        "AnotherPage",\n        // Add all allowed pages here\n    };\n\n    public void Navigate(string page)\n    {\n        if (string.IsNullOrEmpty(page) || !_allowedPages.Contains(page))\n        {\n            // Log the attempt or handle accordingly\n            throw new ArgumentException("Invalid page parameter.");\n        }\n\n        try\n        {\n            // Safely navigate to the requested page\n            mainWindow.Frame.Navigate(new Uri($"pack://application:,,,/Views/{page}.xaml"));\n        }\n        catch (Exception ex)\n        {\n            // Log the exception and notify the user gracefully\n            Console.WriteLine("An error occurred while navigating: " + ex.Message);\n        }\n    }\n}