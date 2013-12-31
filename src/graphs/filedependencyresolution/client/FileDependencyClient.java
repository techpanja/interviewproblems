package graphs.filedependencyresolution.client;

import graphs.filedependencyresolution.FileDependency;
import graphs.filedependencyresolution.FileDependencyImpl;
import graphs.filedependencyresolution.FileOptions;

import java.util.Scanner;

/**
 * Client layer for File Dependency resolution.
 * User: rpanjrath
 * Date: 10/27/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileDependencyClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileDependency fileDependency = new FileDependencyImpl(10);
        FileOptions fileOptions = null;
        //TODO move client code to Impl. Make client thinner.
        while (true) {
            String option = scanner.next();
            if (option.equalsIgnoreCase("exit")) {
                System.exit(1);
            }
            try {
                fileOptions = FileOptions.valueOf(option);
            } catch (IllegalArgumentException ex) {
                System.out.println("Please enter a valid option.");
                scanner = new Scanner(System.in);
            }
            if (fileOptions != null) {
                switch (fileOptions) {
                    case DEPENDS: {
                        fileOptions = null;
                        String file1 = scanner.next();
                        String file2 = scanner.next();
                        if (file1.isEmpty() || file2.isEmpty()) {
                            System.out.println("Please enter valid file name.");
                        }
                        if (!fileDependency.depends(file1, file2)) {
                            System.out.println("Please make sure file exists OR there is no existing dependency.");
                        } else {
                            System.out.println(file1 + " depends on " + file2);
                        }
                        break;
                    }
                    case INSTALL: {
                        fileOptions = null;
                        String file = scanner.next();
                        if (file.isEmpty()) {
                            System.out.println("Please enter valid file name.");
                        }
                        fileDependency.install(file);
                        break;
                    }
                    case REMOVE: {
                        fileOptions = null;
                        String file = scanner.next();
                        if (file.isEmpty()) {
                            System.out.println("Please enter valid file name.");
                        }
                        fileDependency.remove(file);
                    }
                    case LIST: {
                        fileOptions = null;
                        fileDependency.list();
                    }

                }
            }
        }
    }
}
