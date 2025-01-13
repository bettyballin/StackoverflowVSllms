using System;\nusing System.ComponentModel;\nusing System.Windows.Forms;\n\npublic class MyComponent : Component\n{\n    public Form GetParentForm()\n    {\n        // Check if the component is sited and that the site has a container.\n        if (this.Site != null && this.Site.Container != null)\n        {\n            foreach (var component in this.Site.Container.Components)\n            {\n                // Find the form that contains this component.\n                if (component is Form form)\n                {\n                    return form;\n                }\n            }\n        }\n        return null;  // Return null if no parent form is found.\n    }\n}