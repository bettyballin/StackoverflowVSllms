public class Item\n   {\n       public int Id { get; set; }\n       public string Name { get; set; }\n   }\n\n   public class ItemListViewModel\n   {\n       public IList<Item> Items { get; set; }\n   }