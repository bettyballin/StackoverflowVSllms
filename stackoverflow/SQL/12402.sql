declare @first datetime\nset @first = '2009-04-30 19:47:16.123'\ndeclare @second datetime\nset @second = '2009-04-10 19:47:16.123'\n\nselect (cast(@first as float) - floor(cast(@first as float))) -\n       (cast(@second as float) - floor(cast(@second as float)))\n       as Difference