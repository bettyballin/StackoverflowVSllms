select * from orders o\nwhere o.orderdate between @startdate AND @enddate\nand ((@Closed = 1 And o.ClosedDate IS NULL) Or (@Closed = 0 And o.ClosedDate IS NOT NULL))