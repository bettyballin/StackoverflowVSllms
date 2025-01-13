select a.dealid\n, a.dealname\n, a.dealdetails\n, b.dcid\n, b.commenttime\n, b.commentperson\n, b.comment\nfrom deals a, dealcomments b\nwhere b.dealid = a.dealid\n  and b.commenttime = (select max(x.commenttime)\n                       from dealcomments x\n                       where x.dealid = b.dealid)