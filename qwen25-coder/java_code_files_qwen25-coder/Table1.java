// Define annotations
@interface Entity {}

@interface Table {
    String name();
}

@interface Id {}

// Example entities
@Entity
@Table(name = "table1")
class Table1 {
    @Id
    private Long id;
    private Long id2;
    private Long id3;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getId2() { return id2; }
    public void setId2(Long id2) { this.id2 = id2; }

    public Long getId3() { return id3; }
    public void setId3(Long id3) { this.id3 = id3; }
}

@Entity
@Table(name = "table2")
class Table2 {
    @Id
    private Long id;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}

@Entity
@Table(name = "table3")
class Table3 {
    @Id
    private Long id;
    private Long id2;
    private Long id3;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getId2() { return id2; }
    public void setId2(Long id2) { this.id2 = id2; }

    public Long getId3() { return id3; }
    public void setId3(Long id3) { this.id3 = id3; }
}

// HQL Query using subqueries
/*
SELECT t1, t2, t3
FROM Table1 t1,
(SELECT * FROM table2 WHERE id = :table1Id) AS t2,
(SELECT * FROM table3 WHERE id2 = :table1Id2 AND id3 = :table1Id3) AS t3
WHERE t1.id = :table1Id
AND t1.id = t2.id
AND t1.id2 = t3.id2
AND t1.id3 = t3.id3
*/