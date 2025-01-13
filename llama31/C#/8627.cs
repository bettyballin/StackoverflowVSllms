var grouped = from a in table\n              group a by a.ID into g\n              select new fooObject()\n              {\n                  DATE = g.Max(a => a.DATE),\n                  NAME = g.First().NAME, // Assuming NAME is the same for all items with the same ID\n                  ID = g.Key // Use the group key instead of selecting ID again\n              };