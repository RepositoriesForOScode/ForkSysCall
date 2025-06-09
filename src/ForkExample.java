public class ForkExample {
    public static void main(String[] args) { //public- access to jvm/ static- doesnt need object/ string[] args- recieves command line arguments
        System.out.println("hello world (pid:" + ProcessHandle.current().pid() + ")"); //returns an object representing the current 
        //running process() gets the process ID. this line identifies the parent ptocess before creting the child

        ProcessBuilder pb = new ProcessBuilder("java",  "-cp", "src", "ChildProcess"); // cretes a process builder object in order to create
        // a new process, child process. java is the command to run at runtime and ChildProcess is the name of the class that has its own
        // main method source path of childPorcess needs to be specified
        try {
            Process child = pb.inheritIO().start(); // tells java to use the same terminal for child process, also starts child process
            int exitCode = child.waitFor();         // wait for child to finish
            System.out.println("hello, I am parent of " + child.pid() + " (pid:" + ProcessHandle.current().pid() + ")"); //prints the childs pid
            // and the parents pid
            System.out.println("child exited with code " + exitCode); // exit code is what the main method in childprocess returns, 0 for success
            // and 1 for failure
        } catch (Exception e) {
            System.err.println("fork failed");
            e.printStackTrace();
            System.exit(1);
        }
    }
}

// this is the command line to run the code
// javac src/ForkExample.java src/ChildProcess.java
//java -cp src ForkExample