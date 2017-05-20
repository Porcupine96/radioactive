package pl.edu.agh.radioactive;



public class Radio {
    private int radioProgram;

    public Radio(){
        //default programme
        radioProgram = 1;
    }

    public int getRadioProgram(){
        return radioProgram;
    }

    public void changeProgram(int nr){
        radioProgram = nr;
    }

}
