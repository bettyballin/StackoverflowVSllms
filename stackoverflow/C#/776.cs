var sortedRedAtTop = \n    from col in ColorNumList \n    order by col.Color == Red ? 1 : 2\n    select col;