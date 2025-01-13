using System;\nusing System.Runtime.InteropServices;\nusing Microsoft.SharePoint;\nusing Microsoft.SharePoint.Utilities;\nusing Microsoft.SharePoint.Workflow;\nusing System.Xml;\nusing Microsoft.SharePoint.Administration;\n\nnamespace YourNamespace\n{\n    [Guid("your-guid")]\n    public class YourFeatureReceiver : SPFeatureReceiver\n    {\n        public override void FeatureActivated(SPFeatureReceiverProperties properties)\n        {\n            SPSite site = properties.Feature.Parent as SPSite;\n            if (site != null)\n            {\n                SPWebApplication webApp = site.WebApplication;\n                AddConfigNode(webApp, "configuration/system.diagnostics", "<add ... />"); // Add your configuration settings here.\n            }\n        }\n\n        public override void FeatureDeactivating(SPFeatureReceiverProperties properties)\n        {\n            SPSite site = properties.Feature.Parent as SPSite;\n            if (site != null)\n            {\n                SPWebApplication webApp = site.WebApplication;\n                RemoveConfigNode(webApp, "configuration/system.diagnostics", "<add ... />"); // Remove your configuration settings if necessary.\n            }\n        }\n\n        private void AddConfigNode(SPWebApplication webApp, string parentXPath, string newNode)\n        {\n            SPWebConfigModification modification = new SPWebConfigModification();\n            modification.Path = parentXPath;\n            modification.Name = "add[@key='YourKey']"; // Customize as needed.\n            modification.Sequence = 0;\n            modification.Owner = "YourFeature";\n            modification.Type = SPWebConfigModification.SPWebConfigModificationType.EnsureChildNode;\n            modification.Value = newNode;\n\n            webApp.WebConfigModifications.Add(modification);\n            webApp.Update();\n            webApp.Farm.Services.GetValue<SPWebService>().ApplyWebConfigModifications();\n        }\n\n        private void RemoveConfigNode(SPWebApplication webApp, string parentXPath, string nodeName)\n        {\n            foreach (SPWebConfigModification modification in webApp.WebConfigModifications)\n            {\n                if (modification.Owner == "YourFeature" && modification.Path == parentXPath && modification.Name == nodeName)\n                {\n                    webApp.WebConfigModifications.Remove(modification);\n                    break;\n                }\n            }\n\n            webApp.Update();\n            webApp.Farm.Services.GetValue<SPWebService>().ApplyWebConfigModifications();\n        }\n    }\n}