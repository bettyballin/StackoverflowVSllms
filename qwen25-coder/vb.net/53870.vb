Dim classCodeDetails As List(Of ClassCodeDetail) = \n    db.ClassCodeHeaders.Single(Function(cch)\n        cch.CLCH_ID = classCodeHeaderId\n    ).ClassCodeDetails.ToList()\n\nclassCodeDetails = (From ccd In classCodeDetails\n                    Order By ccd.Make.MAKE_English, ccd.Model.MODL_English\n                    Select ccd).ToList()