package org.apache.drill.exec.store.opentsdb.schema;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.calcite.schema.Table;
import org.apache.drill.exec.store.AbstractSchema;

public class TsdbSchema extends AbstractSchema {

  public TsdbSchema(List<String> parentSchemaPath, String name) {
    super(parentSchemaPath, name);
    // TODO Auto-generated constructor stub
  }

  @Override
  public String getTypeName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AbstractSchema getSubSchema(String name) {
    return null;
  }
  
  @Override
  public Set<String> getSubSchemaNames() {
    return Collections.emptySet();
  }
  
  @Override
  public Table getTable(String name) {
    // TODO - could return an "opentsdb" table name
    return null;
  }
}
