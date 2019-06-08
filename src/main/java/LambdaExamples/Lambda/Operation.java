package LambdaExamples.Lambda;

public interface Operation<T> {
    T getResult(T v1, T v2);
}
