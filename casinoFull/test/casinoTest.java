import org.junit.Test;
import org.junit.jupiter.api.Test;
import rideTheBus.rideTheBus;

import static org.junit.Assert.assertEquals;

public class casinoTest {

    @Test
    public void rtbTestOne(){
       rideTheBus game = new rideTheBus();
        game.rideTheBusMain(1000);
    }
}
