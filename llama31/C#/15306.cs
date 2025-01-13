using System.Web.Http;\n\nnamespace ImageServer\n{\n    public class ImageController : ApiController\n    {\n        [HttpGet]\n        public HttpResponseMessage GetImage()\n        {\n            string imagePath = @"\\server\share\image.png";\n            byte[] imageBytes = File.ReadAllBytes(imagePath);\n            HttpResponseMessage response = new HttpResponseMessage(HttpStatusCode.OK);\n            response.Content = new ByteArrayContent(imageBytes);\n            response.Content.Headers.ContentType = new MediaTypeHeaderValue("image/png");\n            return response;\n        }\n    }\n}