package apps.com.certapp.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Insert
    void insertQuestion (Question question);

    @Query("Select * FRom Question")
    List<Question> getAllQuestions();
}
