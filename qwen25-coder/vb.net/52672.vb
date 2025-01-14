Dim ComputedData = From p In AllOrders _\n                   Order By p.Field(Of String)("EmpCode") _\n                 Group By Key = p.Field(Of String)("EmpCode") Into Group _\n                 Select EmpCode = Key, _\n                        Consumption = DirectCast(Group.Sum(Function(p) Convert.ToDecimal(p("Amount"))), Decimal)