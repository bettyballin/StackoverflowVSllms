// DAO example\npublic class UserDAO {\n    public User GetUser(int id) {\n        // database access logic here\n    }\n\n    public void CreateUser(User user) {\n        // database access logic here\n    }\n}\n\n// DAL example\npublic class DataAccessLayer {\n    private UserDAO userDAO;\n    private ProductDAO productDAO;\n\n    public DataAccessLayer() {\n        userDAO = new UserDAO();\n        productDAO = new ProductDAO();\n    }\n\n    public User GetUser(int id) {\n        return userDAO.GetUser(id);\n    }\n\n    public void CreateUser(User user) {\n        userDAO.CreateUser(user);\n    }\n\n    public Product GetProduct(int id) {\n        return productDAO.GetProduct(id);\n    }\n}