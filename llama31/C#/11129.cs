using System.Globalization;\n\nvar countries = CountryInfo.GetCountries()\n    .Select(ci => ci.GetName(new CultureInfo("de-DE")));