private void DoWork()\n    {\n        var thread = new System.Threading.Thread(() =>\n        {\n            // Perform long-running operation here\n\n            // Marshal calls back to the UI thread if necessary\n            System.Windows.Forms.Control control = // some UI control\n            control.Invoke((MethodInvoker)delegate\n            {\n                // Interact with PowerPoint object model here\n            });\n        });\n\n        thread.SetApartmentState(System.Threading.ApartmentState.STA);\n        thread.Start();\n    }