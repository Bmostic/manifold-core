package org.manifold.intermediate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class TestConstraint {

  private static final Type boolType = BooleanType.getInstance();
  private static final ConstraintType defaultConstraintDefinition =
      new ConstraintType(ImmutableMap.of("v", boolType));

  @Test
  public void testGetAttribute() throws Exception {
    Value v = new BooleanValue(boolType, true);
    Constraint ept = new Constraint(defaultConstraintDefinition, ImmutableMap.of("v", v));
    Value vActual = ept.getAttribute("v");
    assertEquals(v, vActual);
  }

  @Test(expected = org.manifold.intermediate.UndeclaredAttributeException.class)
  public void testGetAttribute_nonexistent() throws Exception {
    Value v = new BooleanValue(boolType, true);
    Constraint ept = new Constraint(defaultConstraintDefinition, ImmutableMap.of("v", v));
    ept.getAttribute("bogus");
  }

  @Test(expected = org.manifold.intermediate.UndeclaredAttributeException.class)
  public void testMissingAttribute() throws Exception {
    new Constraint(defaultConstraintDefinition, ImmutableMap.of());
  }

  @Test(expected = org.manifold.intermediate.UndeclaredAttributeException.class)
  public void testExtraAttribute() throws Exception {
    Value v = new BooleanValue(boolType, true);
    new Constraint(defaultConstraintDefinition, ImmutableMap.of("v", v, "vBogus", v));
  }
}
