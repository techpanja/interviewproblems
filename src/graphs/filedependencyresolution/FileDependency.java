package graphs.filedependencyresolution;

/**
 * VALID OPTIONS:
 * DEPENDS -- will add the files and there dependency. If file already exists, it will update dependency.
 * e.g. DEPENDS item1 item2
 * INSTALL -- It will install the all the dependencies of the file first.
 * e.g. INSTALL item1
 * REMOVE -- will uninstall the file and its dependencies if they are not used by other files
 * e.g. REMOVE item1
 * LIST -- will list all the installed files.
 * e.g. LIST
 *
 * Else will return invalid option.
 *
 * User: rpanjrath
 * Date: 10/25/13
 * Time: 5:34 PM
 */
public interface FileDependency {

    boolean depends(String file1, String file2);

    boolean install(String file);

    boolean remove(String file);

    void list();
}
