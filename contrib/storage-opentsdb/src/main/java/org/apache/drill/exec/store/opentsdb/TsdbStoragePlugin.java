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
package org.apache.drill.exec.store.opentsdb;

import java.io.IOException;

import org.apache.calcite.schema.SchemaPlus;
import org.apache.drill.common.logical.StoragePluginConfig;
import org.apache.drill.exec.server.DrillbitContext;
import org.apache.drill.exec.store.AbstractStoragePlugin;
import org.apache.drill.exec.store.SchemaConfig;
import org.apache.drill.exec.store.opentsdb.schema.TsdbSchemaFactory;

public class TsdbStoragePlugin extends AbstractStoragePlugin {
  static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TsdbStoragePlugin.class);
  
  private final DrillbitContext context;
  
  private final TsdbStoragePluginConfig config;
  
  private final TsdbSchemaFactory schemaFactory;
  
  public TsdbStoragePlugin(final TsdbStoragePluginConfig config, 
      final DrillbitContext context, final String name) {
    logger.info("HERHERHERE IN THE TSDB STORAGE PLUGIN CTOR!!!");
    this.context = context;
    this.config = config;
    schemaFactory = new TsdbSchemaFactory(this, name);
  }
  
  @Override
  public StoragePluginConfig getConfig() {
    return config;
  }

  @Override
  public void registerSchemas(SchemaConfig schemaConfig, SchemaPlus parent)
      throws IOException {
    logger.info("Registering TSDB SCHEMA! with config: " + schemaConfig);
    logger.info("Registering TSDB SCHEMA! with parent: " + parent);
    schemaFactory.registerSchemas(schemaConfig, parent);
  }

}
