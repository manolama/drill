package org.apache.drill.exec.store.opentsdb;

import java.io.IOException;

import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.drill.exec.planner.logical.DrillTable;
import org.apache.drill.exec.store.StoragePlugin;

import net.opentsdb.core.TSDB;
import net.opentsdb.utils.Config;

public class TsdbTable extends DrillTable {
  
  private final TSDB tsdb;

  public TsdbTable(final String storageEngineName, final TsdbStoragePlugin plugin,
      final Object selection) {
    super(storageEngineName, plugin, selection);
    tsdb = new TSDB(((TsdbStoragePluginConfig)plugin.getConfig()).getTSDConfig());
  }

  @Override
  public RelDataType getRowType(final RelDataTypeFactory factory) {
    // TODO Auto-generated method stub
    return null;
  }

}
