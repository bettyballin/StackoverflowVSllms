if @someParameter <> 'ThisType'\nbegin\n    set @someCode = right(cast(@pYear as varchar(6)),2) + 'THIS'\n    print 'Some message'\nend