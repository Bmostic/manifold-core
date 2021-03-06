package org.manifold.compiler;

import java.util.Map;

public class ConstraintType extends TypeValue {

  public ConstraintType(Map<String, TypeValue> attributes) {
    super(attributes);
  }

  public ConstraintType(Map<String, TypeValue> attributes, 
      ConstraintType supertype) {
    super(supertype, attributes);
  }

  public void accept(SchematicValueVisitor visitor) {
    visitor.visit(this);
  }

}
