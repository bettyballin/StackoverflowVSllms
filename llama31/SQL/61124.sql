Switch(dbo_tbl_property.LASTSERVICEDATE > Contour_dates.[Last CP12 Date], \n    dbo_tbl_property.LASTSERVICEDATE, \n    True, \n    Contour_dates.[Last CP12 Date]) AS MaxDate