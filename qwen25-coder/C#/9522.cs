// Async method example in C# for VB.NET developers, concept is similar\npublic async Task UpdateUIElementAsync()\n{\n    // Simulate work being done asynchronously\n    await Task.Delay(2000); // Represents a delay (e.g., network operation)\n\n    // Back on the UI thread\n    if (uiElement.InvokeRequired) // For VB.NET equivalent of InvokeRequired property in Windows Forms\n    {\n        uiElement.Invoke(new Action(() =>\n        {\n            uiElement.Text = "Updated!";\n        }));\n    }\n    else\n    {\n        uiElement.Text = "Updated!";\n    }\n}