// Define the IView, IModel, and Presenter interfaces\npublic interface IView { }\npublic interface IModel { }\npublic class Presenter\n{\n    public Presenter(IModel model, IView view) { }\n}\n\n// In your Shell.xaml.cs\n[Import]\npublic IView MyView { get; set; }\n\n// In your Module.cs (where you define the MEF exports)\n[Export(typeof(IView))]\npublic UserControl MyViewImplementation\n{\n    [ImportingConstructor]\n    public MyViewImplementation([Import(typeof(IModel))] IModel model)\n    {\n        var presenter = new Presenter(model, this);\n    }\n}\n\n[Export(typeof(IModel))]\npublic class MyModelImplementation : IModel { }