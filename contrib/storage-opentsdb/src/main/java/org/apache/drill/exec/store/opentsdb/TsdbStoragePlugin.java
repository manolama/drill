package org.apache.drill.exec.store.opentsdb;

import java.io.IOException;

import org.apache.calcite.schema.SchemaPlus;
import org.apache.drill.common.logical.StoragePluginConfig;
import org.apache.drill.exec.server.DrillbitContext;
import org.apache.drill.exec.store.AbstractStoragePlugin;
import org.apache.drill.exec.store.SchemaConfig;

public class TsdbStoragePlugin extends AbstractStoragePlugin {

  private final DrillbitContext context;
  
  private final TsdbStoragePluginConfig config;
  
  public TsdbStoragePlugin(final TsdbStoragePluginConfig config, 
      final DrillbitContext context, final String name) {
    this.context = context;
    this.config = config;
  }
  
  @Override
  public StoragePluginConfig getConfig() {
    return config;
  }

  @Override
  public void registerSchemas(SchemaConfig schemaConfig, SchemaPlus parent)
      throws IOException {
    // TODO Auto-generated method stub
    
  }

}
