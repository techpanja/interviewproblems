package graphs.filedependencyresolution.client;

import graphs.filedependencyresolution.FileDependency;
import graphs.filedependencyresolution.FileDependencyImpl;
import graphs.filedependencyresolution.FileOptions;

import java.util.Scanner;

/**
 * Client layer for File Dependency resolution.
 * User: TECHPANJA
 * Date: 10/27/13
 * Time: 5:59 PM
 */
public class FileDependencyClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileDependency fileDependency = new FileDependencyImpl(10);
        FileOptions fileOptions = FileOptions.LIST;
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
                        String file1 = scanner.next();
                        String file2 = scanner.next();
                        if (!fileDependency.depends(file1, file2)) {
                            System.out.println("Please make sure file exists OR there is no existing dependency.");
                        } else {
                            System.out.println(file1 + " depends on " + file2);
                        }
                        break;
                    }
                    case INSTALL: {
                        fileDependency.install(scanner.next());
                        break;
                    }
                    case REMOVE: {
                        String file = scanner.next();
                        fileDependency.remove(file);
                    }
                    case LIST: {
                        fileDependency.list();
                    }
                }
            }
        }
    }
}
