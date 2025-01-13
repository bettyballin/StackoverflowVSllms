class Program\n{\n    static void Main(string[] args)\n    {\n        // Initialize the model, view, and controller\n        Person model = new Person();\n        PersonView view = new PersonView();\n        PersonController controller = new PersonController(model, view);\n\n        // Set the person details using the view\n        controller.SetPersonDetails();\n\n        // Update the view to display the person details\n        controller.UpdateView();\n    }\n}