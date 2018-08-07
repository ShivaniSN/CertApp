package apps.com.certapp.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Question {

    @NonNull
    @PrimaryKey
    public String questionId;

    @ColumnInfo
    public String question;

    @ColumnInfo
    public String answer;

    public Question(){

    }

    public void setQuestionId(@NonNull String questionId) {
        this.questionId = questionId;
    }

    @NonNull
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
