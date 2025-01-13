using System.Globalization;\n\nvar countries = CultureInfo.GetCultures(CultureTypes.AllCultures & CultureTypes.NeutralCultures)\n    .Select(ci => new RegionInfo(ci.LCID))\n    .Where(ri => ri.Culture.Name.StartsWith("de"))\n    .Select(ri => ri.NativeName);