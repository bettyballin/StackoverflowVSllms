Public Sub ProcessRequest(ByVal context As HttpContext) Implements IHttpHandler.ProcessRequest\n    If Not String.IsNullOrEmpty(context.Request.QueryString("Id")) Then\n        Dim imageId = Convert.ToInt64(context.Request.QueryString("Id"))\n        Dim binaryData As System.Data.Linq.Binary = repository.FindById(imageId).imageData\n        context.Response.ContentType = "image/jpeg" ' Set the appropriate MIME type\n        context.Response.OutputStream.Write(binaryData.ToArray(), 0, binaryData.Length)\n        context.Response.End()\n    End If\nEnd Sub