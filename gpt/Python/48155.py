from sqlalchemy.orm import aliased\nfrom sqlalchemy.sql import func\n\n# Assuming you have your Project and Entry classes defined and a relationship like:\n# class Project(Base):\n#     __tablename__ = 'projects'\n#     id = Column(Integer, primary_key=True)\n#     entries = relationship("Entry", back_populates="project")\n#\n# class Entry(Base):\n#     __tablename__ = 'entries'\n#     id = Column(Integer, primary_key=True)\n#     project_id = Column(Integer, ForeignKey('projects.id'))\n#     project = relationship("Project", back_populates="entries")\n\nEntryAlias = aliased(Entry)\n\n# Subquery to count entries per project\nentry_count_subquery = (\n    Session.query(EntryAlias.project_id, func.count(EntryAlias.id).label('entry_count'))\n    .group_by(EntryAlias.project_id)\n    .subquery()\n)\n\n# Main query to filter projects with one or more entries\nprojects_with_entries = (\n    Session.query(Project)\n    .join(entry_count_subquery, Project.id == entry_count_subquery.c.project_id)\n    .filter(entry_count_subquery.c.entry_count > 0)\n).all()\n\nfor project in projects_with_entries:\n    print(project)