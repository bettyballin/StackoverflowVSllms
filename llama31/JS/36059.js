// check for alternating row styles:\nvar RowStyle = table.rows[1].style.cssText;\nvar AltStyle = table.rows[2].style.cssText;\n\n// SORT HAPPENS HERE!!\n//  snip  \n\n// Apply alternating row styles\nif (RowStyle === AltStyle) return true; \nfor (var i=1,il=table.rows.length;i<il;i+=1)\n{\n    if (i%2==0) table.rows[i].style.cssText = RowStyle;\n    else table.rows[i].style.cssText = AltStyle;                 \n}