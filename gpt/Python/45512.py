def get_session(db_name, verbose, test):\n    """\n    Returns current DB session from SQLAlchemy pool.\n\n    >>> session = get_session('Mmusc20090126', False, True)\n    >>> isinstance(session, sqlalchemy.orm.session.Session)\n    True\n    >>> session.query('SELECT 1').scalar()  # This should always return 1 in an SQLite memory database\n    1\n    """\n    if test:\n        engine = create_engine('sqlite:///:memory:', echo=verbose)\n        log_load.debug('DB in RAM.')\n    else:\n        engine = create_engine('sqlite:///' + 'DB/' + db_name + '.db', echo=verbose)\n        log_load.debug('DB stored in file: %s' % 'DB/' + db_name + '.db')\n\n    # Create TABLES: Structures, Interactions, Interactors, PDB_UniProt, UniProtSeq\n    meta.create_all(engine)\n\n    Session = sessionmaker(bind=engine)\n    session = Session()\n\n    return sessio