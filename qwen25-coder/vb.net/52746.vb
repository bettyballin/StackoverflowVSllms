Dim myPlans = _context.Plans.AsExpandable().Where(predicate1)\nDim myDocuments = _context.Documents.AsExpandable().Where(predicate2)\n\nDim combinedPredicate = PredicateBuilder.New(Of DocumentPlanCombined)()\ncombinedPredicate.Or(Function(x) predicate1.Invoke(x.Plan))\ncombinedPredicate.Or(Function(x) predicate2.Invoke(x.Document))\n\nDim test = From d In myDocuments\n           Join p In MyPlans On d.ID Equals p.ID\n           Let combined = New With {.Document = d, .Plan = p}\n           Where combinedPredicate.Expand().Invoke(combined)\n           Select d.Name, p.Name