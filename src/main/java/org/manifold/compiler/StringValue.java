package org.manifold.compiler;

public class StringValue extends Value {

  private final String val;

  public StringValue(TypeValue t, String val) {
    super(t);
    this.val = val;
  }

  @Override
  public boolean isElaborationtimeKnowable() {
    return true;
  }

  @Override
  public boolean isRuntimeKnowable() {
    return false;
  }

  @Override
  public String toString() {
    return val;
  }

  public void accept(SchematicValueVisitor visitor) {
    visitor.visit(this);
  }

}
