package com.bharath.skills.patterns;

import java.util.*;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {


}

class SingleValue implements ValueContainer
{
  public int value;

// please leave this constructor as-is
  public SingleValue(int value)
  {
    this.value = value;
  }

  @Override
  public Iterator<Integer> iterator() {
    return Collections.singleton(value).iterator();
  }

  @Override
  public void forEach(Consumer<? super Integer> action) {

    action.accept(this.value);

  }

  @Override
  public Spliterator<Integer> spliterator() {
    return Collections.singleton(value).spliterator();
  }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
}


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is
  public MyList(Collection<? extends ValueContainer> c)
  {
    super(c);
  }

  public int sum()
  {
    int sum = 0;

    for(ValueContainer container: this){
      for (Integer value: container) {
        sum+=value;
      }
    }

    return sum;
  }

}