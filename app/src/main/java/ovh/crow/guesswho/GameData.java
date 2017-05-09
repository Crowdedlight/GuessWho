package ovh.crow.guesswho;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Olliver on 04/05/2017.
 */

public class GameData {

    public final static int FLAG_QUESTION       = 0;
    public final static int FLAG_ANSWER         = 1;
    public final static int FLAG_GUESS          = 2;
    public final static int FLAG_GUESS_ANSWER   = 3;

    private int noGuess;    // Number of guess'
    private boolean myTurn; // True = your turn. False = Opponents turn.

    private int flagOut;    // outgoing flag
    private int flagIn;     // incoming flag
    private Long attID;
    private Long perID;
    boolean questAnswer;

    private Person selectedPerson;

    GameData(){
        this.noGuess = 0;
        this.flagOut = -1;
        this.flagIn = -1;
        this.attID = 0l;
        this.perID = 0l;
    }

    public void setFlagOut(int f) {this.flagOut = f;}
    private void setFlagIn(int f) {this.flagIn = f;}
    public void setAttID(Long a) {this.attID = a;}
    public void setPerID(Long p) {this.perID = p;}
    public void setQuestAnswer(boolean q) {this.questAnswer = q;}
    public void setMyTurn(boolean t) {this.myTurn = t;}
    public void flipMyTurn() { this.myTurn = !this.myTurn; }
    public void setSelectedPerson(Person p) { this.selectedPerson = p; }
    public void addGuess() { this.noGuess++; }

    public int getFlagOut() {return flagOut;}
    public int getFlagIn() {return flagIn;}
    public Long getAttID() {return attID;}
    public Long getPerID() {return perID;}
    public boolean getQuestAnswer() {return questAnswer;}
    public boolean getMyTurn() {return myTurn;}
    public Person getSelectedPerson() {return selectedPerson;}

    public int getNoGuess() {return noGuess;}
    public void resetData() {
        this.noGuess = 0;
        this.flagOut = -1;
        this.flagIn = -1;
        this.attID = 0l;
        this.perID = 0l;
    }

    public String toJSON(){
        JSONObject obj = new JSONObject();
        try {
            obj.put("flagOut", getFlagOut());
            obj.put("attID", getAttID());
            obj.put("perID", getPerID());
            obj.put("questAnswer", getQuestAnswer());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj.toString();
    }

    public void fromJSON(String JSONString){
        try {
            JSONObject obj = new JSONObject(JSONString);
            setFlagIn(obj.getInt("flagOut"));
            setAttID(obj.getLong("attID"));
            setPerID(obj.getLong("perID"));
            setQuestAnswer(obj.getBoolean("questAnswer"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String DEBUGtoJSON(){
        JSONObject obj = new JSONObject();
        try {
            obj.put("flagOut", getFlagIn());
            obj.put("attID", getAttID());
            obj.put("perID", getPerID());
            obj.put("questAnswer", getQuestAnswer());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj.toString();
    }
}
