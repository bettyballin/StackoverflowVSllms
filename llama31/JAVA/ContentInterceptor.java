import java.io.Serializable;
import java.lang.String;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.TableMetadata;
import org.hibernate.sql.Insert;
import org.hibernate.type.Type;

public class ContentInterceptor extends EmptyInterceptor {
    
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof Content) {
            Content content = (Content) entity;
            // Get the connection type and content type IDs from the content object
            Integer connectionTypeId = content.getConnectionTypeId();
            Integer contentType1Id = content.getContentType1Id();
            Integer contentType2Id = content.getContentType2Id();
            
            // Get the session and the join table's metadata
            Session session = getSession();
            ClassMetadata classMetadata = session.getSessionFactory().getClassMetadata(Content.class);
            if (classMetadata instanceof TableMetadata) {
                TableMetadata metadata = (TableMetadata) classMetadata;
                org.hibernate.mapping.Table joinTable = metadata.getJoinTable("content_content_connections");
                
                // Create a new insert statement for the join table
                Insert insert = new Insert(joinTable);
                insert.addColumns(joinTable.getColumn("CONTENT_ID1"), joinTable.getColumn("CONTENT_ID2"), 
                        joinTable.getColumn("connection_type_id"), joinTable.getColumn("content_type1_id"), 
                        joinTable.getColumn("content_type2_id"));
                insert.addValues(content.getId(), content.getFoo().getId(), connectionTypeId, contentType1Id, contentType2Id);
                
                // Execute the insert statement
                session.doWork(connection -> connection.executeUpdate(insert.toSqlString(), insert.getValues()));
            }
        }
        return super.onSave(entity, id, state, propertyNames, types);
    }

	public static void main(String[] args) {
	}
}