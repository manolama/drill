package org.apache.drill.exec.store.opentsdb;

import java.util.List;

import org.apache.drill.common.exceptions.ExecutionSetupException;
import org.apache.drill.exec.physical.PhysicalOperatorSetupException;
import org.apache.drill.exec.physical.base.AbstractGroupScan;
import org.apache.drill.exec.physical.base.PhysicalOperator;
import org.apache.drill.exec.physical.base.SubScan;
import org.apache.drill.exec.proto.CoordinationProtos.DrillbitEndpoint;

public class TsdbGroupScan extends AbstractGroupScan {

  public TsdbGroupScan(String userName) {
    super(userName);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void applyAssignments(List<DrillbitEndpoint> endpoints)
      throws PhysicalOperatorSetupException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public SubScan getSpecificScan(int minorFragmentId)
      throws ExecutionSetupException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getMaxParallelizationWidth() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String getDigest() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PhysicalOperator getNewWithChildren(List<PhysicalOperator> children)
      throws ExecutionSetupException {
    // TODO Auto-generated method stub
    return null;
  }

}
