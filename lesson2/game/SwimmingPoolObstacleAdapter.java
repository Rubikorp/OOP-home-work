import ru.gb.lesson2.game.SwimmingPoll;

public class SwimmingPoolObstacleAdapter implements OObstacle {
    
    private final SwimmingPoll swimmingPoll;

    public SwimmingPoolObstacleAdapter(SwimmingPoll swimmingPoll) {
        this.swimmingPoll = swimmingPoll;
    }

    @Override
    public boolean pass(Participant participant) {
        return swimmingPoll.pass(participant);
    }
}
