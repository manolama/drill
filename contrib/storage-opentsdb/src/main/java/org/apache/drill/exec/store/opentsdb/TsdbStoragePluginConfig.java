package org.apache.drill.exec.store.opentsdb;

import java.io.IOException;

import org.apache.drill.common.logical.StoragePluginConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.opentsdb.utils.Config;

public class TsdbStoragePluginConfig extends StoragePluginConfig {
  private static final Logger LOG = 
      LoggerFactory.getLogger(TsdbStoragePluginConfig.class);
  
  private Config config;
  
  @JsonCreator
  public TsdbStoragePluginConfig() {
    try {
      config = new Config(true);
    } catch (IOException e) {
      LOG.error("Failed loading TSDB config", e);
      throw new RuntimeException("Failure loading TSDB config", e);
    }
  }
  

  @JsonCreator
  public TsdbStoragePluginConfig(@JsonProperty("config_file") String configFile) {
    try {
      config = new Config(configFile);
    } catch (IOException e) {
      LOG.error("Failed loading TSDB config: " + configFile, e);
      throw new RuntimeException("Failure loading TSDB config: " + configFile, e);
    }
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TsdbStoragePluginConfig that = (TsdbStoragePluginConfig) o;
    return config.equals(that.config);
  }

  @Override
  public int hashCode() {
    return config != null ? config.hashCode() : 0;
  }

  public Config getTSDConfig() {
    return config;
  }
}
