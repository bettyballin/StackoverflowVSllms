using System.Windows.Automation;\n\nclass WizardAutomator\n{\n    public void AutomateWizard()\n    {\n        // Find the wizard window\n        AutomationElement wizardWindow = AutomationElement.RootElement.FindFirst(\n            TreeScope.Descendants,\n            new PropertyCondition(AutomationElement.ClassNameProperty, "Wizard97")\n        );\n\n        // Find the "Next" button\n        AutomationElement nextButton = wizardWindow.FindFirst(\n            TreeScope.Descendants,\n            new PropertyCondition(AutomationElement.ClassNameProperty, "Button")\n        );\n\n        // Click the "Next" button until the wizard is complete\n        while (nextButton != null)\n        {\n            nextButton.InvokePattern.Invoke();\n            nextButton = wizardWindow.FindFirst(\n                TreeScope.Descendants,\n                new PropertyCondition(AutomationElement.ClassNameProperty, "Button")\n            );\n        }\n    }\n}