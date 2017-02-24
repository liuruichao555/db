package mysql;

/**
 * Test2
 *
 * @author liuruichao
 * @date 15/9/18 下午1:19
 */
public class Test2 {
    private Object obj;
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        for (int i = 0; i < 10; i++) {
            threadLocal.set(new Object());
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(threadLocal.get());
        }
    }
}
