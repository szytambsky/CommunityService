package pl.tamborski.npeapi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class PropagateDataSql {
    public static void main(String[] args) {
        //insert into post(id, title, content) values (1, 'Test post 1', 'Content 1');
        try {
            File file = new File("src/main/resources/data.sql");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");

            for (int i = 1; i <= 100; i++) {
                bufferedWriter.write(String.format("insert into post(id, title, content, created) values ('%d', 'Test post %d', 'Content %d', '%s')\n",
                        i, i, i, LocalDateTime.now().minusDays(100-i)));
            }

            for (int i = 1; i <= 100; i++) {
                int postId = 1 + i / 10;
                bufferedWriter.write(String.format("insert into comment(id, post_id, content, created) values ('%d', '%d', 'Comment %d', '%s')\n", i, postId, i, LocalDateTime.now().minusDays(100-i)));
            }


            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

