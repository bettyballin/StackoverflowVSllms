for c in session.query(Stuff).all():\n    c.foo = c.foo+1\nsession.commit()