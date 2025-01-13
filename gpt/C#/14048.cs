public class MvcApplication : System.Web.HttpApplication\n{\n    protected void Application_Start()\n    {\n        AreaRegistration.RegisterAllAreas();\n        RouteConfig.RegisterRoutes(RouteTable.Routes);\n      \n        // Simple DI registration\n        var fooService = new FooService();\n        ControllerBuilder.Current.SetControllerFactory(new CustomControllerFactory(fooService));\n    }\n}\n\npublic class CustomControllerFactory : DefaultControllerFactory\n{\n    private readonly IFooService _fooService;\n\n    public CustomControllerFactory(IFooService fooService)\n    {\n        _fooService = fooService;\n    }\n\n    protected override IController GetControllerInstance(RequestContext requestContext, Type controllerType)\n    {\n        if (controllerType == null)\n        {\n            return null;\n        }\n\n        return (IController)Activator.CreateInstance(controllerType, _fooService);\n    }\n}