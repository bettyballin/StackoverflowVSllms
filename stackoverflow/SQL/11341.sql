SELECT @rownum:=@rownum+1 rownum, t.*FROM (SELECT @rownum:=0) r, mytable t;