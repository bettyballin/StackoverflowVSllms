var newWin = window.open(url);             \n\nif(!newWin || newWin.closed || typeof newWin.closed=='undefined') \n{ \n    //POPUP BLOCKED\n}