var filteredResults = people.Where(p => !exclusions.Any(e => e.compositeKey == p.compositeKey)).ToList();