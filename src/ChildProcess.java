public class ChildProcess {
    public static void main(String[] args) {
        System.out.println("hello, I am child (pid:" + ProcessHandle.current().pid() + ")"); // this prints the childs is
    }
}
