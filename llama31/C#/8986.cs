public class DDW2FileModelBinder : DefaultModelBinder\n{\n    public override object BindModel(ControllerContext controllerContext, ModelBindingContext bindingContext)\n    {\n        var request = controllerContext.HttpContext.Request;\n        var ddw2file = new DDW2File\n        {\n            Name = request.Form["Name"],\n            Length = Convert.ToInt64(request.Form["Length"])\n        };\n        return ddw2file;\n    }\n}