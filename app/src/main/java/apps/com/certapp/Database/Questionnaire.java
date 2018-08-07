package apps.com.certapp.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Question.class},version = 1, exportSchema = false)
public abstract class Questionnaire extends RoomDatabase{
    public abstract QuestionDAO questionDAO();
}
