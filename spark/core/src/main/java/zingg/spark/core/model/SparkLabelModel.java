package zingg.spark.core.model;

import java.util.Map;

import org.apache.spark.sql.types.DataType;

import zingg.common.client.FieldDefinition;
import zingg.common.core.feature.Feature;

public class SparkLabelModel extends SparkModel{
	
	private static final long serialVersionUID = 1L;

	public SparkLabelModel(Map<FieldDefinition, Feature<DataType>> f) {
		super(f);
	}

}
