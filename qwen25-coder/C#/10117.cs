IFormattable formattable = (IFormattable) 10; // Boxing to interface type\n   string formattedNumber = formattable.ToString("C", CultureInfo.CurrentCulture);