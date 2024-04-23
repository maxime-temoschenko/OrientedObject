public class DateBiss extends DateNotBiss{
    @Override protected int maxDayMonth(int m)
    {
        if(m==2)
            return 29;
        else
            return super.maxDayMonth(m);
    }
}
// This application of inheritance is called variation and no it doesn't respect the substitution principle
// because DateBiss is a variant of DateNotBiss not a subtype .
// We should have written an abstract class from which both DateBiss and DateNotBiss would inherit in order to respect
// this princple. The both class woud overide maxDayMonth , this would be a specification Inheritance and would
// respect satisfy the substitution principle.