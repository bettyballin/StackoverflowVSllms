<HandleError()> \nPublic Class HomeController\n    Inherits System.Web.Mvc.Controller\n\n    Function Index() As ActionResult\n        ViewData("Message") = "Welcome to ASP.NET MVC!"\n\n        Return View()\n    End Function\n\n    <Route("Aboutblah")>\n    Function About() As ActionResult\n        Return View()\n    End Function\nEnd Class