class ForeignAgent implements Runnable{
    Voter[] voters;
    public ForeignAgent(Voter[] voters){
        this.voters = voters;
    }
    /*
     * Mtehod to overid
     *  -> executed by the thread
     */
    public void run(){
        
        // Iterate through all voters
        for(Voter voter : voters){
            // Probability
            double probability = Math.random();
            // Influence according to class and if good probability
            if(voter instanceof Retired && probability <= 0.1)
                voter.getInfluenced();
            else if(voter instanceof Worker && probability <= 0.25)
                voter.getInfluenced();
            else if(voter instanceof Student && probability <= 0.4)
                voter.getInfluenced();
        }
    }
}