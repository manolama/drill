/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.drill.exec.store.opentsdb.schema;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.calcite.schema.Table;
import org.apache.drill.exec.store.AbstractSchema;
import org.apache.drill.exec.store.opentsdb.TsdbScanSpec;
import org.apache.drill.exec.store.opentsdb.TsdbStoragePlugin;
import org.apache.drill.exec.store.opentsdb.TsdbStoragePluginConfig;
import org.apache.drill.exec.store.opentsdb.TsdbTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TsdbSchema extends AbstractSchema {
  private static final Logger LOG = LoggerFactory.getLogger(TsdbSchema.class);
  
  final TsdbStoragePlugin plugin;
  
  public TsdbSchema(List<String> parentSchemaPath, String name, 
      final TsdbStoragePlugin plugin) {
    super(parentSchemaPath, name);
    this.plugin = plugin;
  }

  @Override
  public String getTypeName() {
    return TsdbStoragePluginConfig.NAME;
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
    final TsdbScanSpec spec = new TsdbScanSpec(name);
    return new TsdbTable(name, plugin, spec);
  }
}
