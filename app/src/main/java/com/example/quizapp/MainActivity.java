package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private final String[] questions = {"String object is immutable in java","The Java finally block is always executed, whether the exception is handled or not.","The finalize method calls just before the creation of the object","The Object class, in the java.io package","Heap memory is used only by one thread of execution.","JIT stands for Just-In-Time compiler in Java"
,"When a method is declared final then it cant be overridden by the inheriting class.","this() is used to call the default constructor of the same class"
,"An interface can contain interfaces","You can use ClassLoader to load class files before running the java program.","Annotation is a icon"
,"super() is used to call the default constructor of the parent/base class"," to write a runtime exception, you don't have to extend the RunTimeException class."
        ,"Eclipse and NetBeans are the IDE’s of JAVA.","An abstract class do not have a non- abstract method"
};
private final boolean[] answers = {true,true,false,false,false,true,true,true,false,true,false,true,false,true,false};
private int score = 0;
private  int index = 0;
Button yes;
Button no;
TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Welcome to my app", Toast.LENGTH_SHORT).show();
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if the array is not going out of bounds
            if(index<=questions.length - 1){
                //If you have given correct answers
                if(answers[index]) {
                    score++;
                }
                index++;
                if(index<=questions.length - 1){ // if array is not going out of bounds than jump to next question
                    question.setText(questions[index]);// jumping to next question
                }
                //if the array index is out of bounds than print the score
                else{
                    Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
            }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(index<=questions.length-1){
                if(!answers[index]){
                    score++;
                }
                index++;
                if(index<=questions.length-1){
                    question.setText(questions[index]);
                }
                else{
                    Toast.makeText(MainActivity.this, "Your score is:" + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
            }
            }
        });

    }
}