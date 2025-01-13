using FluentNHibernate.REST;\n\n// create a Fluent NHibernate configuration\nvar fluentConfig = new FluentConfiguration();\n\n// create a REST service instance\nvar restService = new RestService(fluentConfig);\n\n// start the REST service\nrestService.Start();