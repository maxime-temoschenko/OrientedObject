public class ForeignAgent implements Runnable {
    private Voter[] voters;
    public ForeignAgent(Voter[] voters){
        this.voters = voters;
    }
    private boolean actInfluence(Voter v){
        double rand = Math.random();
        if(v instanceof Student && rand < 40)
            return true;
        else if(v instanceof Retired && rand < 10)
            return true;
        else if(v instanceof Worker && rand < 25)
            return true;
        return false;
    }
    public void run(){
        for(Voter voter : voters)
            if(actInfluence(voter))
                voter.getInfluenced();
    }
}
