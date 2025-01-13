var container = new WindsorContainer();\n\n// initial registration\ncontainer.Register(\n    Component.For<X.Y.Z.IActivityService>()\n             .ImplementedBy<X.Y.Z.ActivityService>()\n             .ServiceOverrides(ServiceOverride.ForKey("Listeners").Eq(new[] { typeof(X.Y.Z.DefaultActivityListener).FullName }))\n             .LifeStyle.Transient\n);\n\n// get the original registration\nvar originalRegistration = container.GetRegistration<X.Y.Z.IActivityService>();\n\n// update the registration\ncontainer.UpdateRegistration(originalRegistration,\n    r => r.ServiceOverrides(ServiceOverride.ForKey("Listeners").Eq(new[] { typeof(X.Y.Z.DefaultActivityListener).FullName, "MyOtherListenerID" }))\n);