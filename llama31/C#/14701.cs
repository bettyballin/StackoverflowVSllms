public class FooSpecial : Foo\n{\n    public new IList<FooChildSpecial> Children\n    {\n        get { return base.Children.Select(c => new FooChildSpecial(c)).ToList(); }\n    }\n}