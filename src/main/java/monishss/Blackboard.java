package monishss;

public class Blackboard {
    private Blackboard blackboardInstance;
    private Blackboard(){

    }

    public Blackboard getBlackboardInstance(){
        if (blackboardInstance == null){
            blackboardInstance = new Blackboard();
        }

        return blackboardInstance;
    }
}
