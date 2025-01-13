public class DomainContext\n{\n    private readonly IdentityMap<Location> _locationMap = new IdentityMap<Location>();\n\n    public Location GetLocation(Guid id)\n    {\n        return _locationMap.Get(id);\n    }\n}