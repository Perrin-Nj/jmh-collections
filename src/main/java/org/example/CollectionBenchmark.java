package org.example;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class CollectionBenchmark {

  @Param({"10000", "100000", "1000000"})
  private int size;

  private List<Integer> baseData;
  private List<Integer> removeData;

  @Setup(Level.Invocation)
  public void setUp() {
    baseData = new ArrayList<>(size);
    removeData = new ArrayList<>(size / 2);

    for (int i = 0; i < size; i++) {
      baseData.add(i);
      if (i < size / 2) {
        removeData.add(i);
      }
    }
  }

  @Benchmark
  public List<Integer> arrayListAddAll() {
    List<Integer> arrayList = new ArrayList<>();
    arrayList.addAll(baseData);
    return arrayList;
  }

  @Benchmark
  public Set<Integer> hashSetAddAll() {
    Set<Integer> hashSet = new HashSet<>();
    hashSet.addAll(baseData);
    return hashSet;
  }

  @Benchmark
  public List<Integer> arrayListRemoveAll() {
    List<Integer> arrayList = new ArrayList<>(baseData);
    arrayList.removeAll(removeData);
    return arrayList;
  }

  @Benchmark
  public Set<Integer> hashSetRemoveAll() {
    Set<Integer> hashSet = new HashSet<>(baseData);
    hashSet.removeAll(removeData);
    return hashSet;
  }
}
