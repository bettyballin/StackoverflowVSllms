@if (MefConfig.Container.GetExportedValueOrDefault<IPlugin>("PluginName") != null)\n{\n    Html.RenderPartial("PluginPartialView");\n}