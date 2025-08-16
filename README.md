# CollectionBenchmark

This project contains microbenchmarks for comparing the performance of Java `ArrayList` and `HashSet` operations using **JMH (Java Microbenchmark Harness)**.

## Benchmarked Operations

The following operations are measured:

- `arrayListAddAll`: Adds all elements from a source list into a new `ArrayList`.
- `hashSetAddAll`: Adds all elements from a source list into a new `HashSet`.
- `arrayListRemoveAll`: Removes a subset of elements from an `ArrayList`.
- `hashSetRemoveAll`: Removes a subset of elements from a `HashSet`.

Benchmarks are run with different sizes of input data: `10,000`, `100,000`, and `1,000,000` elements.

## How It Works

- **JMH** is used to accurately measure **average time per operation**.
- Warmup iterations allow the JVM to optimize the code before measurement.
- Forking ensures clean, isolated JVM instances for reliable results.
- Measurements are performed in **milliseconds per operation**.
