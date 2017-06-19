import java.io.File;
import java.util.Comparator;

/**
 * Created by benjaminzhang on 20/05/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise9_10 {
    private class FileNameSorter implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            File f1 = (File)o1;
            File f2 = (File)o2;
            if (f1.isDirectory()){
                if (f2.isDirectory())   return f1.getName().compareTo(f2.getName());
                else return -1;
            }
            else{
                if (f2.isDirectory())   return 1;
                else return f1.getName().compareTo(f2.getName());
            }
        }

        private boolean equals(Object o1, Object o2){
            return ((File)o1).getName().equals(((File)o2).getName());
        }
    }

    private static void showDirInfo(File list[]){
        for (int i = 0; i < list.length; i++) {
            if (list[i].isDirectory())  System.out.print("DIRECTORY");
            else    System.out.print(list[i].length() + " bytes");
            System.out.println("\t\t" + list[i]);
        }
    }

    public static void main(String[] args) {
        File path = new File(System.getProperty("user.dir"));
        if (args.length > 0)    path = new File(args[0]);
        if (path.exists() && path.isDirectory())    showDirInfo(path.listFiles());
        else System.out.println("Path not found or not directory");
    }
}
