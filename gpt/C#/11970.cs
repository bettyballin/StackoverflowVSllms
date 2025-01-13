using System.Collections.Generic;\n    using System.Web.Http;\n\n    public class ProductsController : ApiController\n    {\n        private static List<Product> products = new List<Product>\n        {\n            new Product { Id = 1, Name = "Laptop", Price = 799.99M },\n            new Product { Id = 2, Name = "Phone", Price = 499.99M }\n        };\n\n        // GET api/products\n        public IEnumerable<Product> Get()\n        {\n            return products;\n        }\n\n        // GET api/products/5\n        public IHttpActionResult Get(int id)\n        {\n            var product = products.Find(p => p.Id == id);\n            if (product == null)\n            {\n                return NotFound();\n            }\n            return Ok(product);\n        }\n\n        // POST api/products\n        public IHttpActionResult Post([FromBody] Product product)\n        {\n            if (!ModelState.IsValid)\n            {\n                return BadRequest(ModelState);\n            }\n            products.Add(product);\n            return CreatedAtRoute("DefaultApi", new { id = product.Id }, product);\n        }\n\n        // PUT api/products/5\n        public IHttpActionResult Put(int id, [FromBody] Product product)\n        {\n            var existingProduct = products.Find(p => p.Id == id);\n            if (existingProduct == null)\n            {\n                return NotFound();\n            }\n            existingProduct.Name = product.Name;\n            existingProduct.Price = product.Price;\n            return StatusCode(HttpStatusCode.NoContent);\n        }\n\n        // DELETE api/products/5\n        public IHttpActionResult Delete(int id)\n        {\n            var product = products.Find(p => p.Id == id);\n            if (product == null)\n            {\n                return NotFound();\n            }\n            products.Remove(product);\n            return Ok(product);\n        }\n    }