package com.example.TextGame.domain;

import java.util.ArrayList;

public class Character {
    private int number;
    private String name;
    private String photo;
    private String info;
    private ArrayList<Question> questions = new ArrayList<Question>();
    public Character(){}

    // getters
    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
    public String getPhoto(){
        return photo;
    }
    public String getInfo(){
        return info;
    }
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    // setters
    public void setNumber(int x){
        this.number = x;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setPhoto(String ph){
        this.photo = ph; }
    public void setInfo(String i){
        this. info = i;
    }
    public void setQuestions(Question[]  allQuestions) {
        for(int j=0; j<allQuestions.length; j++){
            if(this.number == allQuestions[j].getCharacter()){
                this.questions.add(allQuestions[j]);
            }
        }
    }

    public void setQuestions(){
        ArrayList<Question> allQuestions = getQuestions();
        ArrayList<Question> questions = new ArrayList<>();
        int i=0;
        while(this.number == allQuestions.get(i).getCharacter()){
            questions.add(allQuestions.get(i));
            i++;
        }
    }

    /*
    // get characters: their number, name, info, questions you can ask them (class Question)
    // in file data is written like:
    // number; name; photo; info
    // you can get questions from another file with Question().getQuestionsFromFile() method
     public Character[] getCharactersFromFile() throws IOException {
        Resource resource = new ClassPathResource("static/characters.csv");
        File file = resource.getFile();
        BufferedReader reader = null;
        String line = "";

        Character character1 = new Character();
        Character character2 = new Character();
        Character character3 = new Character();
        Character character4 = new Character();
        Character character5 = new Character();
        Character character6 = new Character();
        Character character7 = new Character();
        Character character8 = new Character();

        Question[] questions = new Question().getQuestionsFromFile();

        Character[] characters = {character1, character2, character3, character4, character5, character6, character7, character8};
        int i = 0;

        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");

                characters[i].setNumber(Integer.valueOf(row[0]));
                characters[i].setName(row[1]);
                characters[i].setPhoto(row[2]);
                characters[i].setInfo(row[3]);
                characters[i].setQuestions(questions);

                i++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {}
        }
        return characters;
    }
*/


}
