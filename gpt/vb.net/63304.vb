<QueryInterceptor("Orders")> _\nPublic Function OnQueryOrders() As Expression(Of Func(Of Orders, Boolean))\n    Return Function(o) o.Customer.ContactName = HttpContext.Current.User.Identity.Name\nEnd Functio