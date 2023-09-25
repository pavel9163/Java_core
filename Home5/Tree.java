import java.io.File;

public class Tree {
    public static void main(String[] args) {
        String rootPath = "./your_root_directory"; // Замените на корневую директорию
        printDirectoryTree(new File(rootPath), 0);
    }

    public static void printDirectoryTree(File directory, int level) {
        if (directory == null || !directory.exists()) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("  "); // Отступ для уровня вложенности
        }

        if (directory.isDirectory()) {
            System.out.println("[" + directory.getName() + "]");
            File[] subFiles = directory.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    printDirectoryTree(subFile, level + 1);
                }
            }
        } else {
            System.out.println(directory.getName());
        }
    }
}
