Imports System.Web.Routing\n\nPublic Class RouteConfig\n    Public Shared Sub RegisterRoutes(routes As RouteCollection)\n        routes.IgnoreRoute("{resource}.axd/{*pathInfo}")\n\n        routes.MapPageRoute("",\n            "Home",\n            "~/Default.aspx")\n\n        routes.MapPageRoute("",\n            "About",\n            "~/About.aspx")\n\n        ' Add additional routes here\n    End Sub\nEnd Class