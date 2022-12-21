package zingg.client.pipe;

import java.io.IOException;

import org.apache.spark.sql.Column;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.types.StructType;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import org.apache.spark.sql.Dataset;

public class SparkPipe extends Pipe<Dataset<Row>, Row, Column> {
    
    @JsonSerialize(using = CustomSchemaSerializer.class)
	protected StructType schemaStruct;
    protected SaveMode mode;
    
    public SaveMode getMode() {
		return mode;
	}


	public void setMode(SaveMode mode) {
		this.mode = mode;
	}


    static class CustomSchemaSerializer extends StdSerializer<StructType> {
		 
        public CustomSchemaSerializer() { 
           this(null); 
       } 
    
       public CustomSchemaSerializer(Class<StructType> t) {
           super(t); 
       }
    
       @Override
       public void serialize(
               StructType value, JsonGenerator gen, SerializerProvider arg2) 
         throws IOException, JsonProcessingException {
           gen.writeObject(value.json());
       }
   }

    
	public StructType getSchemaStruct() {
		return schemaStruct;
	}
	
}
