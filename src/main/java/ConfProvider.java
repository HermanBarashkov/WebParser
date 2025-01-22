import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

public class ConfProvider {
    @Getter
    private static final ConfigReader props = ConfigFactory.newInstance().create(ConfigReader.class);
}
