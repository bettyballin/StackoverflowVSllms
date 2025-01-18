import javax.persistence.*;

@Entity
class YourEntity {

   @Id
   private Long id;

   private String functionResult;

   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public String getFunctionResult() {
       return functionResult;
   }

   public void setFunctionResult(String functionResult) {
       this.functionResult = functionResult;
   }
}

@Entity
@Table(name="YOUR_TABLE")
@NamedNativeQueries({ @NamedNativeQuery(
    name = "callComplexFunction",
    query = "SELECT YOUR_PACKAGE.YOUR_COMPLEX_FUNCTION(:input1, :input2) as result FROM DUAL",
    resultSetMapping = "functionResultMap" )})
@SqlResultSetMappings({ 
    @SqlResultSetMapping(
        name="functionResultMap",
        entities={
            @EntityResult(entityClass=YourEntity.class, fields={
                @FieldResult(name="functionResult", column="result") 
            }) 
        }
    )
})
public class YourEntity_1 {
   @Id
   private Long id;

   // your entity attributes and methods here

   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

	public static void main(String[] args) {
	}
}