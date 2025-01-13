class DefaultAddress(Base):\n    __tablename__ = 'default_address'\n    person_id = Column(Integer, ForeignKey('person.id'))\n    address_id = Column(Integer, ForeignKey('address.id'))\n\n    person = relationship('Person', backref='default_address')\n    address = relationship('Address')