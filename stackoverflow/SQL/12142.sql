SELECT op.id \nFROM opening op \nWHERE op.id NOT IN \n     (SELECT b.openingid \n      FROM booking b \n      WHERE b.bookingtype='C')