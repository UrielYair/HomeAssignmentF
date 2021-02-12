package Ex2.Driver;

import Ex2.OS.OS;

public class Main {

    public static void main(String[] args) {

        OS os = new OS(10);
        os.runJob("aaa");
        os.runJob("ab");
        os.runJob("an");

        os.sleep("aaa",154);

        System.out.println(os.getRunningJobs());
    }
}