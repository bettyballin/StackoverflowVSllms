public class ProductRepository\n   {\n       public IList<Product> GetAllProducts()\n       {\n           using (var session = NHibernateHelper.OpenSession())\n           {\n               return session.Query<Product>().ToList();\n           }\n       }\n\n       public void AddProduct(Product product)\n       {\n           using (var session = NHibernateHelper.OpenSession())\n           {\n               using (var transaction = session.BeginTransaction())\n               {\n                   session.Save(product);\n                   transaction.Commit();\n               }\n           }\n       }\n\n       public void UpdateProduct(Product product)\n       {\n           using (var session = NHibernateHelper.OpenSession())\n           {\n               using (var transaction = session.BeginTransaction())\n               {\n                   session.Update(product);\n                   transaction.Commit();\n               }\n           }\n       }\n\n       public void DeleteProduct(Product product)\n       {\n           using (var session = NHibernateHelper.OpenSession())\n           {\n               using (var transaction = session.BeginTransaction())\n               {\n                   session.Delete(product);\n                   transaction.Commit();\n               }\n           }\n       }\n   }