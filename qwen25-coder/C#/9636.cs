public class SomeClass {\n   private List<string> _strings = new List<string>();\n\n   public IEnumerable<string> Strings {\n      get { return _strings; }\n      set { _strings.AddRange(value); } // Ensure you have a setter if needed.\n   }\n}