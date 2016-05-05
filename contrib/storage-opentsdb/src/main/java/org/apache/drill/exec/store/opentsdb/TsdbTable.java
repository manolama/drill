package org.apache.drill.exec.store.opentsdb;

import java.util.ArrayList;

import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.drill.exec.planner.logical.DrillTable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.opentsdb.core.TSDB;

public class TsdbTable extends DrillTable {
  
  // TODO - dunno yet if this is where we instante the TSD. Only one per JVM.
  private final TSDB tsdb;

  public TsdbTable(final String storageEngineName, final TsdbStoragePlugin plugin,
      final Object selection) {
    super(storageEngineName, plugin, selection);
    tsdb = new TSDB(((TsdbStoragePluginConfig)plugin.getConfig()).getTSDConfig());
  }

  @Override
  public RelDataType getRowType(final RelDataTypeFactory factory) {
    ArrayList<RelDataType> typeList = new ArrayList<>();
    ArrayList<String> fieldNameList = new ArrayList<>();
    
    fieldNameList.add("metric");
    typeList.add(factory.createSqlType(SqlTypeName.VARCHAR));
    
    fieldNameList.add("timestamp");
    typeList.add(factory.createSqlType(SqlTypeName.BIGINT));
    
    // TODO - integers too
    fieldNameList.add("value");
    typeList.add(factory.createSqlType(SqlTypeName.DOUBLE));
    
    // TODO - tags? How do we handle those?
    
    return factory.createStructType(typeList, fieldNameList);
  }

  @JsonIgnore
  public TSDB getTSDB() {
    return tsdb;
  }
}
