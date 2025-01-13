// Sort the original accessories list instead of creating a new one\naccessories.Sort(new ItemTpComparer(sortOrder));\n\nclass ItemTpComparer : IComparer<Accessories>\n{\n    private IList<int> otherList;\n\n    public ItemTpComparer(IList<int> otherList)\n    {\n        this.otherList = otherList;\n    }\n\n    public int Compare(Accessories x, Accessories y)\n    {\n        // This is a more efficient way to compare based on index\n        return otherList.IndexOf(x.AccessoryId).CompareTo(otherList.IndexOf(y.AccessoryId));\n    }\n}