import java.util.*;

abstract class Question {
    protected String correctAnswer, studentAnswer;
    protected int points;
    public Question(String ca,String sa,int pts){ correctAnswer=ca; studentAnswer=sa; points=pts; }
    public abstract double grade();
}

class MCQ extends Question {
    public MCQ(String ca,String sa,int pts){ super(ca,sa,pts); }
    public double grade(){ return studentAnswer.equals(correctAnswer)? points:0; }
}

class TF extends Question {
    public TF(String ca,String sa,int pts){ super(ca,sa,pts); }
    public double grade(){ return studentAnswer.equals(correctAnswer)? points:0; }
}

class Essay extends Question {
    public Essay(String ca,String sa,int pts){ super(ca,sa,pts); }
    public double grade(){
        String[] keywords = correctAnswer.split(",");
        int match=0;
        for(String kw:keywords){
            if(studentAnswer.toLowerCase().contains(kw.trim().toLowerCase())) match++;
        }
        if(match>=2) return points*0.75;
        else if(match==1) return points*0.5;
        else return 0;
    }
}

public class ClassProblem4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total=0;
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim().split(" ")[0];
            String questionText = parts[1];
            String correctAns = parts[3];
            String studentAns = parts[5];
            int pts = Integer.parseInt(parts[6].trim());
            Question q = switch(type){
                case "MCQ" -> new MCQ(correctAns,studentAns,pts);
                case "TF" -> new TF(correctAns,studentAns,pts);
                case "ESSAY" -> new Essay(correctAns,studentAns,pts);
                default -> null;
            };
            double score = q.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total+=score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
