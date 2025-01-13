// Example API call to create a new class diagram in Enterprise Architect via Automation Interface (script example)\nEA.Repository repository = new EA.Repository();\nrepository.OpenFile("C:\\Path\\To\\YourProject.eap");\n\nEA.Package package_ = repository.GetPackageByGuid("{GUID_OF_YOUR_PACKAGE}");\nEA.Diagram diagram = package_.Diagrams.AddNew("Example Diagram", "ClassDiagram");\ndiagram.InsertIntoDiagram(repository.GetElementByPath("\\Model\\MyClass"), 0, 0, 2);\ndiagram.Update();\n\nrepository.RefreshModelView(0);