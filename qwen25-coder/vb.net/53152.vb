Dim razzies = bloops.Where(Function(b) b.FirstName.StartsWith("J")) _\n                      .Select(Function(b) New Razzie With {\n                          .FirstName = b.FirstName,\n                          .LastName = b.LastName\n                      }).ToList()