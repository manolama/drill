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

import java.io.IOException;

import org.apache.calcite.schema.SchemaPlus;
import org.apache.drill.exec.store.SchemaConfig;
import org.apache.drill.exec.store.SchemaFactory;
import org.apache.drill.exec.store.opentsdb.TsdbStoragePlugin;
import org.apache.drill.exec.store.opentsdb.TsdbStoragePluginConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

public class TsdbSchemaFactory implements SchemaFactory {
  private static final Logger LOG = LoggerFactory.getLogger(TsdbSchemaFactory.class);
  
  private final TsdbStoragePlugin plugin;
  private final String name;
  
  public TsdbSchemaFactory(final TsdbStoragePlugin plugin, final String name) {
    LOG.info("INSTANTIATED SCHEMA FACTORY: " + name);
    this.plugin = plugin;
    this.name = name;
  }
  
  @Override
  public void registerSchemas(SchemaConfig schemaConfig, SchemaPlus parent)
      throws IOException {
    LOG.info("REGISTERED SCHEMA: " + name);
    final TsdbSchema schema = new TsdbSchema(ImmutableList.<String>of(), name, plugin);
    SchemaPlus hPlus = parent.add(name, schema);
    //schema.setHolder(hPlus);
  }

  
}
