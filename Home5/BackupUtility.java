import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackupUtility {
    public static void main(String[] args) {
        String sourceDir = "./your_source_directory"; // Замените на путь к исходной директории
        String backupDir = "./backup"; // Путь к директории для резервных копий

        try {
            createBackup(sourceDir, backupDir);
            System.out.println("Резервные копии созданы успешно.");
        } catch (IOException e) {
            System.err.println("Ошибка при создании резервных копий: " + e.getMessage());
        }
    }

    public static void createBackup(String sourceDir, String backupDir) throws IOException {
        File sourceDirectory = new File(sourceDir);
        File backupDirectory = new File(backupDir);

        if (!sourceDirectory.isDirectory()) {
            throw new IllegalArgumentException("Указанный источник не является директорией.");
        }

        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());

        File backupSubDirectory = new File(backupDirectory, "backup_" + timestamp);
        backupSubDirectory.mkdir();

        File[] files = sourceDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                Path sourcePath = file.toPath();
                Path backupPath = new File(backupSubDirectory, file.getName()).toPath();
                Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
