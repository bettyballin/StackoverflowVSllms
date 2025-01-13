using System.Configuration;\nusing System.Web.Configuration;\n\nConfiguration config = WebConfigurationManager.OpenWebConfiguration(Request.ApplicationPath);\nAuthorizationSection section = (AuthorizationSection)config.GetSection("system.web/authorization");\n\nAuthorizationRule rule = new AuthorizationRule(AuthorizationRuleAction.Allow);\nrule.Roles.Add("admins");\nsection.Rules.Add(rule);\n\nconfig.Save();